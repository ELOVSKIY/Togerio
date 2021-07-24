plugins {
    kotlin("js")
}
val kotlin_version: String by project
val wrapper_version: String by project
val react_version: String by project
val kotlin_styled_version: String by project
val router_dom_version: String by project
val redux_version: String by project
val react_redux_version: String by project
val ring_ui_version: String by project
val ktor_version: String by project
val coroutines_version: String by project
val logback_version: String by project

println(kotlin_version)
println(wrapper_version)
println(react_version)
println(kotlin_styled_version)
println(router_dom_version)
println(redux_version)
println(react_redux_version)
println(ring_ui_version)
println(ktor_version)

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
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-js:$ktor_version")
    implementation("io.ktor:ktor-client-serialization:$ktor_version")
    implementation("io.ktor:ktor-client-auth:$ktor_version")
    implementation("io.ktor:ktor-client-logging:$ktor_version")

    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")

    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:$react_version-pre.$wrapper_version-kotlin-$kotlin_version")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:$react_version-pre.$wrapper_version-kotlin-$kotlin_version")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:$kotlin_styled_version-pre.$wrapper_version-kotlin-$kotlin_version")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:$router_dom_version-pre.$wrapper_version-kotlin-$kotlin_version")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-redux:$redux_version-pre.$wrapper_version-kotlin-$kotlin_version")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-redux:$react_redux_version-pre.$wrapper_version-kotlin-$kotlin_version")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-ring-ui:$ring_ui_version-pre.$wrapper_version-kotlin-$kotlin_version")
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