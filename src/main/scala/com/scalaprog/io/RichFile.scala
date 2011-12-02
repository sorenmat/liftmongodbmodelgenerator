package com.scalaprog.io
import java.io._
import scala.io._

class RichFile(file: File) {

  def text = Source.fromFile(file).mkString

  def text_=(s: String) {
    val out = new PrintWriter(file)
    try { out.println(s) }
    finally { out.close }
  }
}

object RichFile {

  implicit def enrichFile(file: File) = new RichFile(file)

}