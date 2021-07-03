package com.helicoptera.togerio.routing.registration

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import com.helicoptera.togerio.data.network.NetworkResponse
import com.helicoptera.togerio.main
import com.helicoptera.togerio.module
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.server.testing.*

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

private const val USERNAME = "username"
private const val PASSWORD = "password"
private const val USERNAME_KEY = "username"
private const val PASSWORD_KEY = "password"
private const val URI = "/registration"

@KtorExperimentalLocationsAPI
class RegistrationKtTest {

    private lateinit var jsonObject: JsonObject

    @Before
    fun setUp() {
        jsonObject = JsonObject().apply {
            add(USERNAME_KEY, JsonPrimitive(USERNAME))
            add(PASSWORD_KEY, JsonPrimitive(PASSWORD))
        }
    }

    @Test
    fun testRegistration() = withTestApplication(Application::module) {
        val request = handleRequest {
            method = HttpMethod.Post
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
            uri = URI
            setBody(jsonObject.toString())
        }
        with(request) {
            assertEquals(HttpStatusCode.OK, response.status())

            val content = response.content
            if (content != null) {
                val networkResponse = Gson().fromJson<NetworkResponse<String>>(content, NetworkResponse::class.java)
                val value = networkResponse.value
                assertNotNull(value)
                assertNull(networkResponse.error)
            } else {
                fail()
            }
        }
    }

    @Test
    fun testRegistrationWithoutUsername() = withTestApplication(Application::module) {
        jsonObject.remove(USERNAME_KEY)
        val request = handleRequest {
            method = HttpMethod.Post
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
            uri = URI
            setBody(jsonObject.toString())
        }
        with(request) {
            assertEquals(HttpStatusCode.OK, response.status())

            val content = response.content
            if (content != null) {
                val networkResponse = Gson().fromJson<NetworkResponse<String>>(content, NetworkResponse::class.java)
                assertNull(networkResponse.value)
                assertEquals(networkResponse.error, "Username can not be null")
            } else {
                fail()
            }
        }
    }

    @Test
    fun testRegistrationWithoutPassword() = withTestApplication(Application::module) {
        jsonObject.remove(PASSWORD_KEY)
        val request = handleRequest {
            method = HttpMethod.Post
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
            uri = URI
            setBody(jsonObject.toString())
        }
        with(request) {
            assertEquals(HttpStatusCode.OK, response.status())

            val content = response.content
            if (content != null) {
                val networkResponse = Gson().fromJson<NetworkResponse<String>>(content, NetworkResponse::class.java)
                assertNull(networkResponse.value)
                assertEquals(networkResponse.error, "Password can not be null")
            } else {
                fail()
            }
        }
    }
}