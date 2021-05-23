plugins {
    kotlin("js")
}

group = "com.helicoptera"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlin/p/kotlin/kotlin-js-wrappers") }
}

dependencies {
    testImplementation(kotlin("test-js"))
    implementation(project(":application"))
    implementation("org.jetbrains:kotlin-react:16.13.1-pre.113-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-pre.113-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-styled:1.0.0-pre.113-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-react-router-dom:5.1.2-pre.113-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-redux:4.0.0-pre.113-kotlin-1.4.0")
    implementation("org.jetbrains:kotlin-react-redux:5.0.7-pre.113-kotlin-1.4.0")
}

kotlin {
    js(LEGACY) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}