package com.helicoptera.togerio.db.table

import com.helicoptera.togerio.data.dto.project.issue.IssueEntity
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object Issues : Table("Issues") {

    val id = Issues.integer("id").uniqueIndex().autoIncrement()
    val title = Issues.varchar("title", length = 255).uniqueIndex()
    val description = Issues.varchar("description", length = 255)

    override val primaryKey = PrimaryKey(id, name = "PK_Issue_ID")

    fun toProjectModel(row: ResultRow): IssueEntity {
        return IssueEntity(
            id = row[id],
            title = row[title],
            description = row[description],
        )
    }
}