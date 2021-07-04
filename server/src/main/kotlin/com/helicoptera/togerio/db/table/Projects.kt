package com.helicoptera.togerio.db.table

import com.helicoptera.togerio.data.entity.project.Project
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object Projects : Table("Projects") {

    val id = integer("id").uniqueIndex().autoIncrement()
    val name = varchar("name", length = 255).uniqueIndex()
    val code = varchar("code", length = 255)
    val description = varchar("description", length = 255)

    override val primaryKey = PrimaryKey(id, name = "PK_Project_ID")

    fun toProjectModel(row: ResultRow): Project {
        return Project(
            id = row[id],
            name = row[name],
            code = row[code],
            description = row[description],
        )
    }
}