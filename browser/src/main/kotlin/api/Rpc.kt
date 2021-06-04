package api

import kotlinx.browser.window
import org.w3c.fetch.INCLUDE
import org.w3c.fetch.RequestCredentials
import org.w3c.fetch.RequestInit
import kotlin.js.json

suspend fun <T> postAndParseResult(url: String, body: dynamic, parse: (dynamic) -> T): T =
    requestAndParseResult("POST", url, body, parse)

suspend fun <T> getAndParseResult(url: String, body: dynamic, parse: (dynamic) -> T): T =
    requestAndParseResult("GET", url, body, parse)

suspend fun <T> requestAndParseResult(method: String, url: String, body: dynamic, parse: (dynamic) -> T): T {
    console.log(method)
    console.log(body)
    val responsePromise = window.fetch(url, object : RequestInit {
        override var method: String? = method
        override var body: dynamic = body
        override var credentials: RequestCredentials? = RequestCredentials.INCLUDE

        override var headers: dynamic = json(
            "Accept" to "application/json"
        )
    })
    val response = responsePromise.await()
    console.log(response)
    return parse(response.json().await())
}