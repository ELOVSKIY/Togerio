plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

group = "com.helicoptera"
version = "1.0-SNAPSHOT"

repositories {
    google()
    jcenter()
}

dependencies {
    implementation(project(":model"))
    implementation(project(":common"))
    implementation(project(":client-network"))

    implementation(Dependencies.Client.Android.constraintLayout)
    implementation(Dependencies.Client.Android.appCompat)
    implementation(Dependencies.Client.Android.material)

    // Navigation
    implementation(Dependencies.Client.Android.navigationFragment)
    implementation(Dependencies.Client.Android.navigationUI)

    // Lifecycle
    implementation(Dependencies.Client.Android.lifecycleLiveData)
    implementation(Dependencies.Client.Android.lifecycleViewModel)

    implementation(Dependencies.Client.Android.roomRuntime)
//    implementation(Dependencies.Client.Android.roomCompiler)
    implementation(Dependencies.Client.Android.roomCoroutines)
    kapt(Dependencies.Client.Android.roomCompiler)

    implementation(Dependencies.Client.Android.hilt)
    kapt(Dependencies.Client.Android.hiltCompilerKapt)
}

android {
    compileSdkVersion(Configuration.Android.compileSdkVersion)
    defaultConfig {
        applicationId = "com.helicoptera.android"
        minSdkVersion(Configuration.Android.minSdkVersion)
        targetSdkVersion(Configuration.Android.targetSdkVersion)
        versionCode = Configuration.Android.versionCode
        versionName = Configuration.Android.versionName
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        dataBinding = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

kapt {
    correctErrorTypes = true
}