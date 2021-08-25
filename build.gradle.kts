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
        classpath(Dependencies.Client.Android.hiltClassPath)
    }
}

group = "com.helicoptera"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}