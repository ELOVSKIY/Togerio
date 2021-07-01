package com.helicoptera.togerio.routing.location

import io.ktor.locations.*

@KtorExperimentalLocationsAPI
@Location("/authorization")
data class AuthorizationLocation(val username: String, val password: String)
