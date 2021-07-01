package com.helicoptera.togerio.routing.project

import com.helicoptera.togerio.routing.location.project.ProjectLocation
import io.ktor.locations.*
import io.ktor.routing.Routing

@KtorExperimentalLocationsAPI
fun Routing.project() {
    location<ProjectLocation> {
        createProjectRoute()
    }
}