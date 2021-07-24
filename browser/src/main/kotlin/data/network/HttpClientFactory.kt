package data.network

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.js.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.auth.providers.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*
import io.ktor.client.statement.*

class HttpClientFactory {

    //TODO delete sample code
    private val client = HttpClient(Js) {
        install(JsonFeature)
        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(accessToken = "hello", refreshToken = "world")
                }

                refreshTokens { response: HttpResponse ->
                    BearerTokens(accessToken = "hello", refreshToken = "world")
                }
            }
        }
    }

    fun createHttpClient(): HttpClient {
        val httpClientConfig = createHttpClientConfig()

        return HttpClient(Js).config { httpClientConfig }
    }

    private fun createHttpClientConfig() : HttpClientConfig<HttpClientEngineConfig> {
        return HttpClientConfig<HttpClientEngineConfig>().apply {
            install(JsonFeature)
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }
}