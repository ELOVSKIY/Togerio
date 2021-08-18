object Dependencies {

    object Server {
        val ktorCore = "io.ktor:ktor-server-core:${Versions.ktorVersion}"
        val ktorGson = "io.ktor:ktor-gson:${Versions.ktorVersion}"
        val ktorServerNetty = "io.ktor:ktor-server-netty:${Versions.ktorVersion}"

        val ktorAuth = "io.ktor:ktor-auth:${Versions.ktorVersion}"
        val ktorAuthJwt = "io.ktor:ktor-auth-jwt:${Versions.ktorVersion}"
        val ktorLocations = "io.ktor:ktor-locations:${Versions.ktorVersion}"

        val exposedCore = "org.jetbrains.exposed:exposed-core:${Versions.exposedVersion}"
        val exposedJdbc = "org.jetbrains.exposed:exposed-jdbc:${Versions.exposedVersion}"

        val h2Database = "com.h2database:h2:${Versions.h2Version}"

        val logback = "ch.qos.logback:logback-classic:${Versions.logbackVersion}"

        object Test {
            val ktorServerTests = "io.ktor:ktor-server-tests:${Versions.ktorVersion}"
            val jUinit = "test-junit"
        }
    }

    object Client {
        object Browser {
            val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"

            val ktorCore = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
            val ktorJs = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
            val ktorSerialization = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
            val ktorAuth = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
            val ktorLogging = "io.ktor:ktor-client-logging:$${Versions.ktorVersion}"

            val react = "org.jetbrains.kotlin-wrappers:kotlin-react:${Versions.Client.Browser.reactVersion}-pre.${Versions.Client.Browser.wrapperVersion}-kotlin-${Versions.kotlinVersion}"
            val reactDom = "org.jetbrains.kotlin-wrappers:kotlin-react-dom:${Versions.Client.Browser.reactVersion}-pre.${Versions.Client.Browser.wrapperVersion}-kotlin-${Versions.kotlinVersion}"
            val kotlinStyled = "org.jetbrains.kotlin-wrappers:kotlin-styled:${Versions.Client.Browser.kotlinStyledVersion}-pre.${Versions.Client.Browser.wrapperVersion}-kotlin-${Versions.kotlinVersion}"
            val reactRouterDom = "org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:${Versions.Client.Browser.routerDomVersion}-pre.${Versions.Client.Browser.wrapperVersion}-kotlin-${Versions.kotlinVersion}"
            val redux = "org.jetbrains.kotlin-wrappers:kotlin-redux::${Versions.Client.Browser.reduxVersion}-pre.${Versions.Client.Browser.wrapperVersion}-kotlin-${Versions.kotlinVersion}"
            val reactRedux = "org.jetbrains.kotlin-wrappers:kotlin-react-redux::${Versions.Client.Browser.reactReduxVersion}-pre.${Versions.Client.Browser.wrapperVersion}-kotlin-${Versions.kotlinVersion}"
        }

        object Android {

        }
    }
}