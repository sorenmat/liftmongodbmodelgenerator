package com.scalaprog.metamodel
import com.scalaprog.metamodel.MetaObject

class MetaClass(val id: String, val name: String, val packageName: String) extends MetaObject {
  var attributes: List[MetaObject] = List()

  override def toString = {
    val sb = new StringBuilder()
    sb.append("package " + packageName + "\n");
    sb.append("import net.liftweb.mongodb._\n");
    sb.append("import net.liftweb.mongodb.record._\n");
    sb.append("import net.liftweb.mongodb.record.field._\n");
    sb.append("import net.liftweb.record.field.StringField\n");
    sb.append("import net.liftweb.mongodb.record.MongoRecord\n");
    sb.append("import net.liftweb.mongodb.record.MongoMetaRecord\n");
    sb.append("import net.liftweb.mongodb.record.MongoId\n");

    sb.append("class " + name.capitalize + " private() extends MongoRecord[" + name.capitalize + "] with MongoId[" + name.capitalize + "]{\n")
    sb.append("def meta = " + name.capitalize + "\n")
    sb.append(attributes.map(a => a.toString()).mkString("\n"))
    sb.append("}\n\n")
    sb.append("object " + name.capitalize + " extends " + name.capitalize + " with MongoMetaRecord[" + name.capitalize + "]")
    sb.toString

  }
}
/*
 * 
 * import net.liftweb.mongodb._
import net.liftweb.record.field.StringField
import net.liftweb.mongodb.record.field.ObjectIdField
import net.liftweb.mongodb.record.MongoRecord
import net.liftweb.mongodb.record.MongoMetaRecord
import net.liftweb.mongodb.record.MongoId

class ServerInstance private () extends MongoRecord[ServerInstance] with MongoId[ServerInstance] {
        def meta = ServerInstance

        def getSingleton = ServerInstance
        def primaryKeyField = id

        object EntryId extends StringField(this, 14)

       
 */

