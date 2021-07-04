package com.helicoptera.togerio.routing.projects

import com.helicoptera.togerio.authorization.validation.project.issue.IssueValidator
import com.helicoptera.togerio.data.entity.issue.Issue
import com.helicoptera.togerio.data.entity.project.Project
import com.helicoptera.togerio.db.transaction.fetchUserByUsername
import com.helicoptera.togerio.db.transaction.project.createProject
import com.helicoptera.togerio.db.transaction.project.createProjectMember
import com.helicoptera.togerio.db.transaction.project.fetchProjectByCode
import com.helicoptera.togerio.routing.processUserPrincipal
import com.helicoptera.togerio.routing.processUserPrincipal
import com.helicoptera.togerio.routing.processValidationResult
import com.helicoptera.togerio.routing.utils.processProjectAccess
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.routing.*

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