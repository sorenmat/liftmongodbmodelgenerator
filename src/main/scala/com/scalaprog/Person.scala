package com.scalaprog
import net.liftweb.mongodb._
import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field._
import net.liftweb.record.field.StringField
import net.liftweb.mongodb.record.MongoRecord
import net.liftweb.mongodb.record.MongoMetaRecord
import net.liftweb.mongodb.record.MongoId
class Person private() extends MongoRecord[Person] with MongoId[Person]{
def meta = Person
	object name extends StringField(this,15)

	object email extends StringField(this,15)

object address extends ObjectIdRefField(this,Address)}

object Person extends Person with MongoMetaRecord[Person]
