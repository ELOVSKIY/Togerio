package com.helicoptera.togerio.data.dto.project

import com.helicoptera.togerio.data.dto.User

data class ProjectMember(
    val user: User,
    val project: Project
)