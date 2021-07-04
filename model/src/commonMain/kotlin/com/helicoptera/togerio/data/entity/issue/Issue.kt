package com.helicoptera.togerio.data.entity.issue

data class Issue(
    val id: Int,
    val title: String,
    val description: String? = null,
    val priority: Priority? = null,
    val type: Type? = null,
    val state: State? = null,
    val fixVersions: List<Version> = listOf(),
    val affectVersions: List<Version> = listOf()
)
