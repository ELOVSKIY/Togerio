plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}

group = "com.helicoptera"
version = "1.0-SNAPSHOT"

repositories {
    google()
    jcenter()
}

dependencies {
    implementation(project(":model"))

    implementation(Dependencies.Client.Android.constraintLayout)
    implementation(Dependencies.Client.Android.appCompat)
    implementation(Dependencies.Client.Android.material)

    //Navigation
    implementation(Dependencies.Client.Android.navigationFragment)
    implementation(Dependencies.Client.Android.navigationUI)

    //Room

}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "com.helicoptera.android"
        minSdkVersion(Configuration.Android.minSdkVersion)
        targetSdkVersion(Configuration.Android.targetSdkVersion)
        versionCode = Configuration.Android.versionCode
        versionName = Configuration.Android.versionName
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}