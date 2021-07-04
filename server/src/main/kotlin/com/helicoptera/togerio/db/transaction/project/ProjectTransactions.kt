package com.helicoptera.togerio.db.transaction.project

import com.helicoptera.togerio.data.entity.project.Project
import com.helicoptera.togerio.db.table.Projects
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun createProject(project: Project): Project? {
    transaction {
        Projects.insert {
            it[name] = project.name
            it[code] =  project.code
            it[description] =  project.description
        }
    }

    return fetchProjectByCode(project.code)
}

fun fetchProjectById(id: Int): Project? {
    val resultRow = transaction {
        Projects.select {
            Projects.id eq id
        }
    }.firstOrNull()


    return if (resultRow != null) Projects.toProjectModel(resultRow) else null
}

fun fetchProjectByCode(code: String): Project? {
    val resultRow = transaction {
        Projects.select {
            Projects.code eq code
        }
    }.firstOrNull()

    return if (resultRow != null) Projects.toProjectModel(resultRow) else null
}