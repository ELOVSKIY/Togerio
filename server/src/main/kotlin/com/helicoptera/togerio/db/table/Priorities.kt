package com.helicoptera.togerio.db.table

import com.helicoptera.togerio.data.entity.project.issue.PriorityEntity
import com.helicoptera.togerio.data.entity.project.issue.TypeEntity
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object Priorities : Table("Types") {

    val id = integer("id").uniqueIndex().autoIncrement()
    val projectId = integer("projectId").references(
        Projects.id,
        onDelete = ReferenceOption.CASCADE,
        onUpdate = ReferenceOption.CASCADE,
        fkName = "FK_Project_Id"
    )
    val title = varchar("title", length = 255).uniqueIndex()
    val description = varchar("description", length = 255)
    val color = varchar("color", length = 9)

    override val primaryKey = PrimaryKey(id, name="PK_Priority_ID")

    fun createEntityFromRow(row: ResultRow): PriorityEntity {
        return PriorityEntity(
            id = row[id],
            projectId = row[projectId],
            title = row[title],
            description = row[description],
            color = row[color]
        )
    }
}