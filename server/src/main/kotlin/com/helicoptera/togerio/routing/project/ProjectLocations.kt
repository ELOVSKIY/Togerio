package com.helicoptera.togerio.routing.project

import io.ktor.locations.*

typealias CreateProjectLocation = ProjectLocations.CreateLocation
typealias IssueLocation = ProjectLocations.ProjectLocation.IssueLocations.IssueLocation
val IssueLocation.projectId: Int
    get() = issueLocations.projectLocation.projectId

@Location("/project")
class ProjectLocations {
    @Location("/{projectId}")
    data class ProjectLocation(val projectId: Int) {
        @Location("/issue")
        data class IssueLocations(val projectLocation: ProjectLocation) {
            @Location("/{issueId}")
            data class IssueLocation(val issueLocations: IssueLocations, val issueId: Int)
        }
    }

    @Location("/create")
    class CreateLocation()
}



