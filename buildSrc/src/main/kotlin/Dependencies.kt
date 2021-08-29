object Dependencies {

    object Common {
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Common.kotlinVersion}"
        const val androidBuildGradle = "com.android.tools.build:gradle:${Versions.Common.androidBuildGradleVersion}"
    }

    object Server {
        const val ktorCore = "io.ktor:ktor-server-core:${Versions.ktorVersion}"
        const val ktorGson = "io.ktor:ktor-gson:${Versions.ktorVersion}"
        const val ktorServerNetty = "io.ktor:ktor-server-netty:${Versions.ktorVersion}"

        const val ktorAuth = "io.ktor:ktor-auth:${Versions.ktorVersion}"
        const val ktorAuthJwt = "io.ktor:ktor-auth-jwt:${Versions.ktorVersion}"
        const val ktorLocations = "io.ktor:ktor-locations:${Versions.ktorVersion}"

        const val exposedCore = "org.jetbrains.exposed:exposed-core:${Versions.exposedVersion}"
        const val exposedJdbc = "org.jetbrains.exposed:exposed-jdbc:${Versions.exposedVersion}"

        const val h2Database = "com.h2database:h2:${Versions.h2Version}"

        const val logback = "ch.qos.logback:logback-classic:${Versions.logbackVersion}"

        object Test {
            const val ktorServerTests = "io.ktor:ktor-server-tests:${Versions.ktorVersion}"
            const val jUinit = "test-junit"
        }
    }

    object Client {
        object Network {
            const val ktorCore = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
            const val ktorJs = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
            const val ktorSerialization = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
            const val ktorAuth = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
            const val ktorLogging = "io.ktor:ktor-client-logging:$${Versions.ktorVersion}"
        }
        object Browser {
            const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"

            const val react = "org.jetbrains.kotlin-wrappers:kotlin-react:${Versions.Client.Browser.reactVersion}-pre.${Versions.Client.Browser.wrapperVersion}-kotlin-${Versions.kotlinVersion}"
            const val reactDom = "org.jetbrains.kotlin-wrappers:kotlin-react-dom:${Versions.Client.Browser.reactVersion}-pre.${Versions.Client.Browser.wrapperVersion}-kotlin-${Versions.kotlinVersion}"
            const val kotlinStyled = "org.jetbrains.kotlin-wrappers:kotlin-styled:${Versions.Client.Browser.kotlinStyledVersion}-pre.${Versions.Client.Browser.wrapperVersion}-kotlin-${Versions.kotlinVersion}"
            const val reactRouterDom = "org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:${Versions.Client.Browser.routerDomVersion}-pre.${Versions.Client.Browser.wrapperVersion}-kotlin-${Versions.kotlinVersion}"
            const val redux = "org.jetbrains.kotlin-wrappers:kotlin-redux::${Versions.Client.Browser.reduxVersion}-pre.${Versions.Client.Browser.wrapperVersion}-kotlin-${Versions.kotlinVersion}"
            const val reactRedux = "org.jetbrains.kotlin-wrappers:kotlin-react-redux::${Versions.Client.Browser.reactReduxVersion}-pre.${Versions.Client.Browser.wrapperVersion}-kotlin-${Versions.kotlinVersion}"
        }

        object Android {
            const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.Client.Android.navigationVersion}"
            const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.Client.Android.navigationVersion}"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.Client.Android.constraintVersion}"
            const val appCompat = "androidx.appcompat:appcompat:${Versions.Client.Android.appCompatVersion}"
            const val material = "com.google.android.material:material:${Versions.Client.Android.materialVersion}"


            //TODO(add dependencies)
            const val roomRuntime = "androidx.room:room-runtime:${Versions.Client.Android.roomVersion}"
            const val roomCompiler = "androidx.room:room-compiler:${Versions.Client.Android.roomVersion}"
            const val roomCoroutines = "androidx.room:room-ktx:${Versions.Client.Android.roomVersion}"

            const val hiltClassPath = "com.google.dagger:hilt-android-gradle-plugin:${Versions.Client.Android.hiltVersion}"
            const val hilt = "com.google.dagger:hilt-android:${Versions.Client.Android.hiltVersion}"
            const val hiltCompilerKapt = "com.google.dagger:hilt-android-compiler:${Versions.Client.Android.hiltVersion}"

            const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Client.Android.lifecycleVersion}"
            const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Client.Android.lifecycleVersion}"
        }
    }
}