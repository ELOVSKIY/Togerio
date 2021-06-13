pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "Togerio"

include(":application")
include(":android")
include(":server")
include(":browser")
include("use-cases")
