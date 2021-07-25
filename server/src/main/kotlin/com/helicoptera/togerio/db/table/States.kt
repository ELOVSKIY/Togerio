package com.helicoptera.togerio.db.table

import com.helicoptera.togerio.data.entity.project.issue.PriorityEntity
import com.helicoptera.togerio.data.entity.project.issue.StateEntity
import com.helicoptera.togerio.data.entity.project.issue.TypeEntity
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object States : Table("States") {

    val id = integer("id").uniqueIndex().autoIncrement()
    val projectId = integer("projectId").references(
        Projects.id,
        onDelete = ReferenceOption.CASCADE,
        onUpdate = ReferenceOption.CASCADE,
        fkName = "FK_State_Project_Id"
    )
    val title = varchar("title", length = 255).uniqueIndex()
    val description = varchar("description", length = 255)
    val complete = bool("complete")
    val color = varchar("color", length = 9)

    override val primaryKey = PrimaryKey(id, name="PK_State_ID")

    fun createEntityFromRow(row: ResultRow): StateEntity {
        return StateEntity(
            id = row[id],
            projectId = row[projectId],
            title = row[title],
            description = row[description],
            complete = row[complete],
            color = row[color]
        )
    }
}