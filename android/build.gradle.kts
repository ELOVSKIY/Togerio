plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
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

    implementation("com.google.devtools.ksp:symbol-processing-api:1.5.21-1.0.0-beta07")
    implementation(Dependencies.Client.Android.roomRuntime)
    implementation(Dependencies.Client.Android.roomCompiler)
    implementation(Dependencies.Client.Android.roomCoroutines)
    kapt(Dependencies.Client.Android.roomCompiler)
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