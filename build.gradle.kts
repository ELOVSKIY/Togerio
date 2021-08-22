buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.Common.kotlin)
        classpath(Dependencies.Common.androidBuildGradle)
    }
}

group = "com.helicoptera"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}