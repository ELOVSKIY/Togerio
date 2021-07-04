package com.helicoptera.togerio.routing.utils

import com.helicoptera.togerio.db.transaction.project.isProjectMember
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.util.pipeline.*

//TODO put member model to block for access project member information
suspend fun PipelineContext<Unit, ApplicationCall>.processProjectAccess(
    projectId: Int, userId: Int,
    block: suspend () -> Unit
) {
    val isProjectMember = isProjectMember(projectId, userId)
    if (isProjectMember) {
        block()
    } else {
        call.respond(HttpStatusCode.Forbidden)
    }
}