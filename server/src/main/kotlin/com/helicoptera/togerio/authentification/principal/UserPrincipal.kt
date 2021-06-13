package com.helicoptera.togerio.authentification.principal

import io.ktor.auth.*

data class UserPrincipal (
    val id: Int
) : Principal
