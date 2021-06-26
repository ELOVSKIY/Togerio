package com.helicoptera.togerio.db.transaction.project

import com.helicoptera.togerio.data.entity.project.Project
import com.helicoptera.togerio.db.table.ProjectMembers
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun createProjectMember(projectId: Int, userId: Int) {
    transaction {
        ProjectMembers.insert {
           it[ProjectMembers.projectId] = projectId
           it[ProjectMembers.userId] = userId
        }
    }
}

fun fetchAllProjectsForUser(userId: Int) : List<Project> {
    val projectsIds = transaction {
        ProjectMembers.select {
           ProjectMembers.userId eq userId
        }
    }.map {
        it[ProjectMembers.id]
    }

    return projectsIds.mapNotNull { projectId ->
        fetchProjectById(projectId)
    }
}

fun fetchAllUsersForProject(projectId: Int) : List<Project> {
    val projectsIds = transaction {
        ProjectMembers.select {
            ProjectMembers.projectId eq projectId
        }
    }.map {
        it[ProjectMembers.id]
    }

    return projectsIds.mapNotNull { projectId ->
        fetchProjectById(projectId)
    }
}