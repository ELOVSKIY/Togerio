package com.helicoptera.togerio.routing.projects

import io.ktor.locations.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
fun Routing.projectsRoute() {
    createProjectRoute()
    projectRoute()
}