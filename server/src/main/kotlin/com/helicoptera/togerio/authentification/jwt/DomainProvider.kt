package com.helicoptera.togerio.authentification.jwt

import com.helicoptera.togerio.utils.getApplicationProperty
import io.ktor.application.*

private const val DEFAULT_DOMAIN = "DOMAIN"
private const val DOMAIN_PATH = "jwt.domain"

fun getDomain(environment: ApplicationEnvironment) : String {
    return getApplicationProperty(environment, DOMAIN_PATH, DEFAULT_DOMAIN)
}