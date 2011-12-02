package bootstrap.liftweb

import net.liftweb._

import util._
import Helpers._
import common._
import http._
import auth._
import net.liftweb.mapper.view.TableEditor
import sitemap._
import Loc._
import S._
import mapper._
import net.liftweb.http.auth.{ AuthRole, HttpBasicAuthentication, userRoles }
import com.mongodb.BasicDBObject
import com.mongodb.Mongo
import net.liftweb.mongodb.{ DefaultMongoIdentifier, MongoDB }
import net.liftweb.widgets.tablesorter.TableSorter

class Boot {
  
  def boot {
    try {
      println("Mongo db init started")
      MongoDB.defineDb(DefaultMongoIdentifier, new Mongo, "test")
      println("Mongo db init completed")

      LiftRules.addToPackages("code")
      LiftRules.addToPackages("com.scalaprog")

      val status = Menu("serverstatus") / "serverstatus" >> If(() => loggedIn_?, "You must be logged in")

      var entries = status :: Nil

      LiftRules.setSiteMap(SiteMap(entries: _*))

      //Show the spinny image when an Ajax call starts
      LiftRules.ajaxStart = Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)

      // Make the spinny image go away when it ends
      LiftRules.ajaxEnd = Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

      // Force the request to be UTF-8
      LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

      // What is the function to test if a user is logged in?
      //			LiftRules.loggedInTest = Full(() => {
      //			})

      // Use HTML5 for rendering
      //LiftRules.htmlProperties.default.set((r: Req) => new Html5Properties(r.userAgent))

      LiftRules.noticesAutoFadeOut.default.set((noticeType: NoticeType.Value) => Full((1 seconds, 2 seconds)))
      // Make a transaction span the whole HTTP request
      //      S.addAround(DB.buildLoanWrapper
    } catch {
      case e: Throwable => e.printStackTrace
    }
  }
}


