package com.helicoptera.togerio.authentification.jwt

import com.auth0.jwt.algorithms.Algorithm
import io.ktor.application.*

fun getAlgorithm(environment: ApplicationEnvironment) : Algorithm {
    val secret = getSecret(environment)

    return Algorithm.HMAC256(secret)
}