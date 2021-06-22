package com.helicoptera.togerio.data.model.project

import com.helicoptera.togerio.data.model.User

data class ProjectMember(
    val user: User,
    val coast: Int,
    val completedTaskCount: Int,
    val processingTaskCount: Int,
    val roles: List<ProjectMemberRole>
)