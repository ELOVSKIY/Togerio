package com.helicoptera.togerio.routing.project

import com.helicoptera.togerio.routing.location.project.ProjectLocation
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.Routing
import io.ktor.locations.location

fun Routing.project() {
    location<ProjectLocation> {
        get("2") {
            call.respond("2")
        }
    }
}