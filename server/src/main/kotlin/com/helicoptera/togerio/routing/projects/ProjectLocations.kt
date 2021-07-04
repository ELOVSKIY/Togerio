package com.helicoptera.togerio.routing.projects

import io.ktor.locations.*

@Location("/project")
class ProjectLocations {
    @Location("/{projectId}")
    data class ProjectLocation(val projectId: Int) {
        @Location("/issue")
        data class IssueLocations(val projectLocation: ProjectLocation) {
            @Location("/{issueId}")
            data class IssueLocation(val issueLocations: IssueLocations, val issueId: Int)

            @Location("/create")
            data class CreateLocation(val issueLocations: IssueLocations)
        }
    }

    @Location("/create")
    class CreateLocation()
}

typealias CreateProjectLocation = ProjectLocations.CreateLocation

typealias IssueLocations = ProjectLocations.ProjectLocation.IssueLocations
typealias CreateIssueLocation = ProjectLocations.ProjectLocation.IssueLocations.CreateLocation
typealias IssueLocation = ProjectLocations.ProjectLocation.IssueLocations.IssueLocation

val IssueLocations.projectId: Int
    get() = projectLocation.projectId
val IssueLocation.projectId: Int
    get() = issueLocations.projectId
val CreateIssueLocation.projectId: Int
    get() = issueLocations.projectId


