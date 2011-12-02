import sbt._
import Keys._
import com.github.siasia.WebPlugin._
import com.github.siasia.PluginKeys._

object MyBuild extends Build {
	lazy val root = Project("TMC", file("."), settings = Defaults.defaultSettings ++ com.github.siasia.WebPlugin.webSettings ++ rootSettings)

	lazy val rootSettings = Seq(
		port := 7070,
//		jettyScanInterval := 60,
		libraryDependencies ++= jetty73Dependencies
		)

	val liftVersion = "2.4-M5"


	def jetty73Dependencies =
		Seq("javax.servlet" % "servlet-api" % "2.5" % "provided",
			"net.liftweb" %% "lift-webkit" % liftVersion % "compile->default" withSources (),
			"net.liftweb" %% "lift-mapper" % liftVersion % "compile->default" withSources (),
			"net.liftweb" %% "lift-widgets" % liftVersion % "compile->default" withSources (),
			"net.liftweb" %% "lift-wizard" % liftVersion % "compile->default" withSources (),
			"net.liftweb" %% "lift-mongodb-record" % liftVersion % "compile->default" withSources (),
			"net.liftweb" %% "lift-json" % liftVersion % "compile->default" withSources (),
			//"net.liftweb" % "lift-json" % "2.0" withSources (),
			
			"org.eclipse.jetty" % "jetty-webapp" % "8.0.1.v20110908" % "container"

			 )

}
