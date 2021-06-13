package com.helicoptera.togerio.authentification.jwt

import com.helicoptera.togerio.utils.getApplicationProperty
import io.ktor.application.*

private const val DEFAULT_SECRET = "SECRET"
private const val SECRET_PATH = "jwt.secret"

fun getSecret(environment: ApplicationEnvironment) : String {
    return getApplicationProperty(environment, SECRET_PATH, DEFAULT_SECRET)
}