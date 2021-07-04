package com.helicoptera.togerio.routing

import com.helicoptera.togerio.authentification.JwtManager
import com.helicoptera.togerio.routing.projects.projectsRoute
import com.helicoptera.togerio.routing.registration.registration
import io.ktor.locations.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
fun Routing.root(jwtManager: JwtManager) {
    projectsRoute()
    registration(jwtManager)
}