package com.helicoptera.togerio.data.network

import com.helicoptera.togerio.data.dto.User
import io.ktor.client.*
import io.ktor.client.request.*

class AuthorizationNetworkClient {

    private val engine = createKtorClient {

    }

    fun makeRegistrationRequest(user: User) {
//        engine.request()
    }
}

fun client() {
}