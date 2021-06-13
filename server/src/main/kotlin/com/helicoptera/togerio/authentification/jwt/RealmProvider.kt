package com.helicoptera.togerio.authentification.jwt

import com.helicoptera.togerio.utils.getApplicationProperty
import io.ktor.application.*

private const val DEFAULT_REALM = "REALM"
private const val REALM_PATH = "jwt.realm"

fun getRealm(environment: ApplicationEnvironment) : String {
    return getApplicationProperty(environment, REALM_PATH, DEFAULT_REALM)
}