package com.helicoptera.togerio.routing.utils

import com.helicoptera.togerio.data.network.NetworkResponse
import com.helicoptera.togerio.validation.ValidationResult
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.util.pipeline.*

suspend fun PipelineContext<Unit, ApplicationCall>.processValidationResult(
    validationResult: ValidationResult,
    block: suspend () -> Unit
) {
    if (validationResult.valid) {
        block()
    } else {
        call.respond(NetworkResponse<Any>(error = validationResult.errorDescription))
    }
}