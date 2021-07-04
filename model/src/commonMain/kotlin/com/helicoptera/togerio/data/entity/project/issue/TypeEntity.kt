package com.helicoptera.togerio.data.entity.project.issue

data class TypeEntity (
    val id: Int,
    val projectId: Int,
    val title: String,
    val description: String,
    val color: String,
)