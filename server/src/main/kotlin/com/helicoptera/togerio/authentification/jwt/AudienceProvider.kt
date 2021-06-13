package com.helicoptera.togerio.authentification.jwt

import com.helicoptera.togerio.utils.getApplicationProperty
import io.ktor.application.*

private const val DEFAULT_AUDIENCE = "AUDIENCE"
private const val AUDIENCE_PATH = "jwt.audience"

fun getAudience(environment: ApplicationEnvironment) : String {
    return getApplicationProperty(environment, AUDIENCE_PATH, DEFAULT_AUDIENCE)
}