package com.helicoptera.togerio.routing.project.current

import com.helicoptera.togerio.routing.project.IssueLocation
import com.helicoptera.togerio.routing.project.projectId
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.currentProject() {
    get<IssueLocation> { issue ->
        call.respond("Project: ${issue.projectId} issue: ${issue.issueId}")
    }
}