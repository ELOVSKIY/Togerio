import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val h2_version: String by project
val exposed_version: String by project
val checkstyle_version: String by project
val jacoco_version: String by project

plugins {
    kotlin("jvm")
    checkstyle
    jacoco
    pmd
}

checkstyle {
    toolVersion = checkstyle_version
    configFile = file("config/checkstyle/style.xml")
    reporting.baseDir = buildDir
}

jacoco {
    toolVersion = jacoco_version
}

pmd {
    isIgnoreFailures = true
}

group = "com.helicoptera"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":model"))
    implementation(project(":common"))

    //Ktor
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-gson:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")

    //Authorization
    implementation("io.ktor:ktor-auth:$ktor_version")
    implementation("io.ktor:ktor-auth-jwt:$ktor_version")

    //Database
    implementation("org.jetbrains.exposed", "exposed-core", "$exposed_version")
    implementation("org.jetbrains.exposed", "exposed-jdbc", "$exposed_version")

    //H2 Database
    implementation("com.h2database:h2:$h2_version")

    //Locations
    implementation("io.ktor:ktor-locations:$ktor_version")
    testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

tasks {
    jacocoTestCoverageVerification {
        violationRules {
            rule { limit { minimum = BigDecimal.valueOf(0.2) } }
        }
    }
    check {
        dependsOn(jacocoTestCoverageVerification)
    }
}

tasks.withType<Checkstyle>().configureEach {
    reports {
        xml.required.set(true)
        html.required.set(true)
        html.stylesheet = resources.text.fromFile("config/xsl/checkstyle-custom.xsl")
    }
}