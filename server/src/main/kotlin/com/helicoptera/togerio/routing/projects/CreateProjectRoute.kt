package com.helicoptera.togerio.routing.projects

import com.helicoptera.togerio.authorization.validation.project.ProjectValidator
import com.helicoptera.togerio.data.entity.project.Project
import com.helicoptera.togerio.data.network.NetworkResponse
import com.helicoptera.togerio.db.transaction.fetchUserByUsername
import com.helicoptera.togerio.db.transaction.project.createProject
import com.helicoptera.togerio.db.transaction.project.createProjectMember
import com.helicoptera.togerio.db.transaction.project.fetchProjectByCode
import com.helicoptera.togerio.routing.processUserPrincipal
import com.helicoptera.togerio.routing.processValidationResult
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.createProjectRoute() {
    val projectValidator = ProjectValidator()

    post<CreateProjectLocation> {
        suspend fun respondSuccess(project: Project) {
            call.respond(NetworkResponse(value = project))
        }

        suspend fun respondFailure(reason: String) {
            call.respond(NetworkResponse<Any>(error = reason))
        }

        processUserPrincipal { userId ->
            val project = call.receive<Project>()
            val validationResult = projectValidator.validateProject(project)
            processValidationResult(validationResult) {
                if (fetchProjectByCode(project.code) == null) {
                    if (fetchUserByUsername(project.name) == null) {
                        val createdProject = createProject(project)
                        if (createdProject != null) {
                            createProjectMember(project.id, userId)
                            respondSuccess(project)
                        } else {
                            respondFailure("Error during creating object")
                        }
                    } else {
                        respondFailure("Project with name code already exists")
                    }
                } else {
                    respondFailure("Project with same code already exists")
                }
            }
        }
    }
}