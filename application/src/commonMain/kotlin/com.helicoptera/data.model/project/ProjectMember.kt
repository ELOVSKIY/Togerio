package com.helicoptera.data.model.project

import com.helicoptera.data.model.User

data class ProjectMember(
    val user: User,
    val coast: Int,
    val roles: List<ProjectMemberRole>
)
