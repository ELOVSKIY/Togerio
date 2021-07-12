package com.helicoptera.togerio.data.entity.project.issue

data class IssueEntity(
    val id: Int,

    val title: String,
    val description: String? = null,
    val number: Int,
    val code: String,
    val projectId: Int,
    val priorityId: Int,
    val typeId: Int,
    val stateId: Int,
)
