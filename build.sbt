
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.0-RC4"

lazy val root = (project in file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "laminar-hello-world",
    libraryDependencies ++= Seq(
      "io.frontroute" %%% "frontroute" % "0.18.1"
    ),
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
    semanticdbEnabled := true,
    autoAPIMappings   := true,
    Compile / mainClass := Some("in.oss.laminar.App")
  )
