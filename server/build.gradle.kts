import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    checkstyle
    jacoco
    pmd
}

checkstyle {
    toolVersion = Versions.checkstyleVersion
    configFile = file("config/checkstyle/style.xml")
    reporting.baseDir = buildDir
}

jacoco {
    toolVersion = Versions.jacocoVersion
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
    implementation(Dependencies.Server.ktorCore)
    implementation(Dependencies.Server.ktorGson)
    implementation(Dependencies.Server.ktorServerNetty)

    //Authorization
    implementation(Dependencies.Server.ktorAuth)
    implementation(Dependencies.Server.ktorAuthJwt)

    //Locations
    implementation(Dependencies.Server.ktorLocations)

    //Database
    implementation(Dependencies.Server.exposedCore)
    implementation(Dependencies.Server.exposedJdbc)

    implementation(Dependencies.Server.logback)

    //H2 Database
    implementation(Dependencies.Server.h2Database)

    testImplementation(kotlin(Dependencies.Server.Test.jUinit))
    testImplementation(Dependencies.Server.Test.ktorServerTests)
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