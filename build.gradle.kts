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
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
    }
}

group = "com.helicoptera"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}