package com.helicoptera.togerio.data.entity.project.issue

data class IssueEntity(
    val id: Int,
    val projectId: Int,
    val code: Int,
    val number: Int,
    val title: String,
    val description: String? = null,
    val priorityId: Int,
    val typeId: Int,
    val stateId: Int,
    val fixVersionsToIssueId: Int,
    val affectVersionsToIssueId: Int,
    val priorityEntity: PriorityEntity? = null,
    val type: TypeEntity? = null,
    val state: StateEntity? = null,
    val fixVersions: List<VersionEntity> = listOf(),
    val affectVersions: List<VersionEntity> = listOf()
)
