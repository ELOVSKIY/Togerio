package com.helicoptera.togerio.data.entity.project

import com.helicoptera.togerio.data.entity.User

data class ProjectMember(
    val user: User,
    val coast: Int = 0,
    val completedTaskCount: Int = 0,
    val processingTaskCount: Int = 0,
)