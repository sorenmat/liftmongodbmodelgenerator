package com.scalaprog.metamodel

class MetaAttribute(val name: String, val typeName: String) extends MetaObject {
  override def toString = {
    if (name == "")
      ""
    else
      "\tobject " + name + " extends " + typeName + "Field(this,15)\n"
  }

}

/*

 object name extends StringField(this, 12)
  object cnt extends IntField(this)

*/