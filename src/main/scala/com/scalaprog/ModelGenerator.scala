package com.scalaprog
import collection.JavaConverters._
import com.scalaprog.metamodel.MetaClass
import metamodel.MetaAttribute
import com.scalaprog.metamodel.MetaClass
import java.nio.file.Path
import com.scalaprog.io.RichFile.enrichFile
import java.io.File
import com.scalaprog.metamodel.MetaPackage
import com.scalaprog.metamodel.MetaAssociation

class ModelGenerator(outputPath: String) {

  val xmiPrefix = "http://schema.omg.org/spec/XMI/2.1"
  val umlPrefix = "http://schema.omg.org/spec/UML/2.1.2"

  val rootzip = new java.util.zip.ZipFile("model/Test.mdzip")
  val entries = rootzip.entries.asScala

  entries foreach { e =>
    val x = scala.xml.XML.load(rootzip.getInputStream(e))
    val packagedElements = x \\ ("@{" + umlPrefix + "}Model")
    val packages = x \\ ("Model") \ "packagedElement"

    val packageName = packages \\ "packagedElement"
    val metaPackages = packages.filter(xml => (xml \\ "@name").text != "").map(f => {
      val packageName = (f \ "@name").text
      val metaPackage = new MetaPackage(packageName)
      val classes = packages \ "packagedElement"

      val metaClasses = classes.map(clazz => {
        val name = (clazz \ "@name").text
        val id = (clazz \ ("@{" + xmiPrefix + "}id")).text
        val metaClass = getMetaClass(id, name, packageName)
        val attributes = clazz \\ "ownedAttribute"
        // add attributes to the class
        val attrs = attributes.map(attribute => {
          if ((attribute \\ "@association").text != "") {
            val typeId = (attribute \ "@type").text
            val aggregationId = (attribute \ "@aggregation").text
            val isSource = aggregationId != ""
            if (isSource)
              Some(new MetaAssociation(name, aggregationId, typeId))
            else
              None
          } else {
            val name = (attribute \ "@name").text
            val tmpType = (attribute \\ "type" \ "@href").text
            val attrType = tmpType.substring(tmpType.indexOf("#") + 1, tmpType.length())
            Some(new MetaAttribute(name, attrType))
          }
        })

        metaClass.attributes = attrs.flatMap(f => f).toList
        metaClass
      })
      metaPackage.classes = metaClasses.toList
      metaPackage
    })

    fixAssociations(metaPackages.toList)
    metaPackages.foreach(pack => {
      val packageDir = outputPath + "/" + pack.name.replace(".", "/")
      new File(packageDir).mkdirs()
      pack.classes.filter(f => f.name != "").foreach(clazz => {
        val f = new File(packageDir + "/" + clazz.name + ".scala")
        f.text = clazz.toString();
      })
    })
  }
  def getMetaClass(id: String, name: String, packageName: String) = new MetaClass(id, name, packageName)
  def getMetaAttribute(name: String, typeName: String) = new MetaAttribute(name, typeName)

  def getAllClasses(metaPackages: List[MetaPackage]) = {
    metaPackages.flatMap(f => f.classes)
  }
  def fixAssociations(metaPackages: List[MetaPackage]) = {
    metaPackages.foreach(pack => {
      pack.classes.foreach(clazz => {
    	  clazz.attributes.filter(f => f.isInstanceOf[MetaAssociation]).foreach(attr => {
    	    getAllClasses(metaPackages).find(elm => elm.id == attr.asInstanceOf[MetaAssociation].tagetId) match {
    	      case Some(x) => attr.asInstanceOf[MetaAssociation].typeName = x.packageName+"."+x.name
    	      case None =>
    	    }
    	  })
      })
    })
    None
  }
}

object ModelGenerator {
  def main(args: Array[String]) {
    new ModelGenerator("src/main/scala")
  }
}
