package code.snippet

import net.liftweb.http._
import net.liftweb._
import net.liftweb.http.provider.servlet.HTTPRequestServlet
import scala.xml._
import SHtml._
import mapper._
import _root_.scala.xml.Text
import java.io.File
import scala.xml.{ NodeSeq, Text }
import net.liftweb._
import http._
import js._
import JsCmds._
import common._
import util._
import Helpers._
import _root_.scala.xml._
import http._
import S._
import SHtml._
import common._
import util._
import Helpers._
import js._
import JsCmds._
import auth._
import com.mongodb._
import net.liftweb.json.JsonDSL._

class TMC {

	def myrender(template: NodeSeq): NodeSeq = {
//				bind("entry", chooseTemplate("instance", "tableEntry", template),
//			"user" -> Text(entry.User.toString),
//			"instancename" -> Text(entry.InstanceName.toString),
//
//			"runningversion" -> link(baseAppURL, () => {}, Text(entry.RunningVersion.toString.replace(".war", ""))),
//			"adminConsoleLink" -> clickableImage(template, baseAppURL + "/foundation/testconsole/testconsole.htm", "images/admin.png", "Admin console page"),
//
//			"RunningVersionMemberWeb" -> link(entry.InstanceName.toString + "/" + memberWebPath, () => {}, Text(entry.RunningMemberWebVersion.toString.replace(".war", ""))),
//
//			"runningdbversion" -> Text(entry.RunningDbVersion.toString.replace(".bak", "")),
//			if (UserHelper.isAdminUser)
//				"deploy" -> clickableImage(template, "/deploy?entry=" + entry.EntryId, "images/deploy.png", "Deploy")
//			else
//				"deploy" -> clickableImage(template, "/simpledeploy?entry=" + entry.EntryId, "images/deploy.png", "Simple deploy"),
//			"undeploy" -> clickableImage(template, "/undeploy?entry=" + entry.EntryId, "images/undeploy.png", "Undeploy"),
//			"showtomcatlog" -> clickableImage(template, entry.InstanceName.toString +"/LogBrowser/showlog", "images/showlog.png", "Show tomcat Log")
//			
//			)
	NodeSeq.Empty
	}

	def clickableImage(xhtml: NodeSeq, url: String, image: String, title: String): NodeSeq = {
		<a href={ url } title={ title }><img src={ image } height="16" width="16"/></a>
	}


}
