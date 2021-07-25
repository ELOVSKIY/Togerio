package com.helicoptera.togerio.routing.utils

import com.helicoptera.togerio.authentification.principal.UserPrincipal
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.util.pipeline.*

suspend fun PipelineContext<Unit, ApplicationCall>.processUserPrincipal(
    block: suspend (userId: Int) -> Unit
) {
    val userPrincipal = call.authentication.principal as? UserPrincipal
    if (userPrincipal != null) {
        block(userPrincipal.id)
    } else {
        call.respond(HttpStatusCode.Unauthorized)
    }
}