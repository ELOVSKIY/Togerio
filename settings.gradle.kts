pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "Togerio"

include(":model")
include(":common")
include(":android")
include(":server")
include(":browser")
include("use-cases")
