package com.helicoptera.togerio.authentification

import com.helicoptera.togerio.authentification.principal.UserPrincipal
import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.helicoptera.togerio.authentification.jwt.getAlgorithm
import com.helicoptera.togerio.authentification.jwt.getAudience
import com.helicoptera.togerio.authentification.jwt.getDomain
import io.ktor.application.*
import io.ktor.auth.jwt.*
import java.util.*

private const val USER_ID_KEY = "id"
private const val VALIDITY_IN_MS = 36_000_00 * 10 // 10 hours

class JwtManager(environment: ApplicationEnvironment) {

    private val algorithm = getAlgorithm(environment)
    private val domain = getDomain(environment)
    private val audience = getAudience(environment)

    val verifier: JWTVerifier = JWT
        .require(algorithm)
        .withAudience(audience)
        .withIssuer(domain)
        .build()

    fun makeToken(user: UserPrincipal): String = JWT.create()
        .withSubject("Authentication")
        .withIssuer(domain)
        .withAudience(audience)
        .withClaim(USER_ID_KEY, user.id)
        .withExpiresAt(getExpiration())
        .sign(algorithm)

    fun verifyCredential(credential: JWTCredential) : UserPrincipal? {
        return if (credential.payload.audience.contains(audience)) {
            val id = credential.payload.claims[USER_ID_KEY]?.asInt()
            if (id != null)  UserPrincipal(id) else null
        } else {
            null
        }
    }


    private fun getExpiration() = Date(System.currentTimeMillis() + VALIDITY_IN_MS)
}
