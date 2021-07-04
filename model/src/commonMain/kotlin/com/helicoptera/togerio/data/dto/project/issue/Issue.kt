package com.helicoptera.togerio.data.dto.project.issue

data class Issue(
    val title: String,
    val description: String? = null,
    val code: String,
    val number: Int,
    val priorityEntity: Priority? = null,
    val type: Type? = null,
    val state: State? = null,
    val fixVersions: List<Version> = listOf(),
    val affectVersions: List<Version> = listOf()
)
