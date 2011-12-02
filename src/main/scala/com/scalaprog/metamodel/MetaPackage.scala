package com.scalaprog.metamodel

class MetaPackage(val name: String) extends MetaObject {
  var classes: List[MetaClass] = List()

  override def toString = name
}