package com.helicoptera.togerio.data.entity.project.issue

data class StateEntity (
    val id: Int,
    val projectId: Int,
    val title: String,
    val description: String,
    val complete: Boolean,
    val color: String,
)