package com.helicoptera.togerio.db.transaction.project

import com.helicoptera.togerio.data.entity.UserEntity
import com.helicoptera.togerio.data.dto.project.Project
import com.helicoptera.togerio.db.table.ProjectMembers
import com.helicoptera.togerio.db.table.Users
import com.helicoptera.togerio.db.transaction.fetchUserByUserId
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

fun fetchAllProjectsForUser(userId: Int): List<Project> {
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

fun fetchAllUsersForProject(projectId: Int): List<UserEntity> {
    val projectsIds = transaction {
        ProjectMembers.select {
            ProjectMembers.projectId eq projectId
        }
    }.map {
        it[Users.id]
    }

    return projectsIds.mapNotNull { id ->
        fetchUserByUserId(id)
    }
}

fun isProjectMember(projectId: Int, userId: Int): Boolean {
    return transaction {
        !ProjectMembers.select {
            ProjectMembers.projectId eq projectId
            ProjectMembers.userId eq userId
        }.empty()
    }
}