package com.scalaprog
import net.liftweb.mongodb._
import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field._
import net.liftweb.record.field.StringField
import net.liftweb.mongodb.record.MongoRecord
import net.liftweb.mongodb.record.MongoMetaRecord
import net.liftweb.mongodb.record.MongoId
class Address private() extends MongoRecord[Address] with MongoId[Address]{
def meta = Address
	object addr extends StringField(this,15)

	object zipCode extends StringField(this,15)
}

object Address extends Address with MongoMetaRecord[Address]
