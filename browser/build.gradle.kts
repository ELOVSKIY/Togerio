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

println(kotlin_version)
println(wrapper_version)
println(react_version)
println(kotlin_styled_version)
println(router_dom_version)
println(redux_version)
println(react_redux_version)
println(ring_ui_version)

group = "com.helicoptera"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlin/p/kotlin/kotlin-js-wrappers") }
    maven { url = uri("https://mvnrepository.com/artifact/org.jetbrains.kotlin-wrappers") }
}

dependencies {
    testImplementation(kotlin("test-js"))
    implementation(project(":model"))
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