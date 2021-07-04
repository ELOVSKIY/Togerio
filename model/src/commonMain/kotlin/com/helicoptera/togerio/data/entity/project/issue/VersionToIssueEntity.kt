package com.helicoptera.togerio.data.entity.project.issue

data class VersionToIssueEntity (
    val id: Int,
    val projectId: Int,
    val issueId: Int,
    val version: Int,
)