package data.network

import com.helicoptera.togerio.data.network.NetworkResponse
import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.auth.providers.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

private const val baseUrl = "http://localhost:8083"

class Api {

    private val httpClientFactory = HttpClientFactory()

    suspend fun registration(username: String, password: String) : String {
        val client = httpClientFactory.createHttpClient()
        val requestHost = StringBuilder(baseUrl).append("/registration").toString()

        client.use { client ->
            val response = client.post<NetworkResponse<String>>() {
                host = requestHost
                body = Json {
                    "username" to username
                    "password" to password
                }
            }

            return ResponseProcessor.processResponse(response)
        }
    }
}