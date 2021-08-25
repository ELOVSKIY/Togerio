package com.helicoptera.togerio.routing.projects

import com.helicoptera.togerio.authorization.validation.project.issue.IssueValidator
import com.helicoptera.togerio.data.dto.project.issue.Issue
import com.helicoptera.togerio.routing.utils.processUserPrincipal
import com.helicoptera.togerio.routing.utils.processValidationResult
import com.helicoptera.togerio.routing.utils.processProjectAccess
import io.ktor.application.*
import io.ktor.locations.post
import io.ktor.request.*
import io.ktor.routing.Routing

fun Routing.createIssueRoute() {
    val issueValidator = IssueValidator()

    post<CreateIssueLocation> { createIssueLocation ->
        val projectId = createIssueLocation.projectId
        processUserPrincipal { userId ->
            processProjectAccess(projectId, userId) {
                val issue = call.receive<Issue>()
                val validationResult = issueValidator.validateIssue(issue)
                processValidationResult(validationResult) {
                    //TODO add issue to db
                }
            }
        }
    }
}