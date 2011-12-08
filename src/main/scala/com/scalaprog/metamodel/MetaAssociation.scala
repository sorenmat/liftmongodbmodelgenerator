package com.scalaprog.metamodel

class MetaAssociation(val name: String, var typeName: String, var tagetId: String) extends MetaObject {
  
  def simpleTypeName = typeName.split("\\.").toSeq.last
  
  //TODO Test for onetomany or manytomany
  override def toString = {
    if (name == "")
      ""
    else
      "object "+simpleTypeName.toLowerCase()+" extends ObjectIdRefField(this,"+simpleTypeName+")"
  }

}

