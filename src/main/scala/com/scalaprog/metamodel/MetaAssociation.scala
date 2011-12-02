package com.scalaprog.metamodel

class MetaAssociation(val name: String, var typeName: String, var tagetId: String) extends MetaObject {
  override def toString = {
    if (name == "")
      ""
    else
      "\t//relation: "+typeName+"\n"
  }

}

/*

 object name extends StringField(this, 12)
  object cnt extends IntField(this)

*/