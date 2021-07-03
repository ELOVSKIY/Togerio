package com.helicoptera.togerio.routing.project

import com.helicoptera.togerio.routing.location.project.ProjectLocation
import com.helicoptera.togerio.routing.project.current.currentProject
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.locations.get
import io.ktor.response.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
fun Routing.project() {
    createProjectRoute()
    currentProject()
}