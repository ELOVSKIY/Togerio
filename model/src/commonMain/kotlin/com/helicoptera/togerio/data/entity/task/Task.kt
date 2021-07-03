package com.helicoptera.togerio.data.entity.task

data class Task(
    val taskId: Int,
    val title: String,
    val descriptions: String,
    val priority: Priority,
    val type: Type,
    val state: State,
    val fixVersions: List<Version>,
    val affectVersions: List<Version>
)
