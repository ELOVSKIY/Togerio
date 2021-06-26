package com.helicoptera.togerio.routing.project

import com.helicoptera.togerio.routing.location.project.ProjectLocation
import io.ktor.routing.Routing
import io.ktor.locations.location

fun Routing.project() {
    location<ProjectLocation> {
        createProjectRoute()
    }
}