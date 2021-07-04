package com.helicoptera.togerio.data.entity.project.issue

data class VersionEntity(
    val id: Int,
    val projectId: Int,
    val title: String,
    val date: String,
    val description: String,
    val color: String
)
