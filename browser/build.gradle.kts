plugins {
    kotlin("js")
}

group = "com.helicoptera"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlin/p/kotlin/kotlin-js-wrappers") }
    maven { url = uri("https://mvnrepository.com/artifact/org.jetbrains.kotlin-wrappers") }
}

dependencies {
    testImplementation(kotlin("test-js"))
    implementation(project(":model"))

    implementation(Dependencies.Client.Browser.ktorCore)
    implementation(Dependencies.Client.Browser.ktorJs)
    implementation(Dependencies.Client.Browser.ktorSerialization)
    implementation(Dependencies.Client.Browser.ktorAuth)
    implementation(Dependencies.Client.Browser.ktorLogging)

    implementation(Dependencies.Client.Browser.coroutinesCore)

    implementation(Dependencies.Client.Browser.react)
    implementation(Dependencies.Client.Browser.reactDom)
    implementation(Dependencies.Client.Browser.kotlinStyled)
    implementation(Dependencies.Client.Browser.reactRouterDom)
    implementation(Dependencies.Client.Browser.redux)
    implementation(Dependencies.Client.Browser.reactRedux)
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}