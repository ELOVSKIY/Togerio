package com.helicoptera.togerio.db.table

import com.helicoptera.togerio.data.entity.project.issue.PriorityEntity
import com.helicoptera.togerio.data.entity.project.issue.VersionToIssueEntity
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object FixVersionsToIssues : Table("FixVersionsToIssues") {

    val id = integer("id").uniqueIndex().autoIncrement()
    val issueId = integer("issueId").references(
        Issues.id,
        onDelete = ReferenceOption.CASCADE,
        onUpdate = ReferenceOption.CASCADE,
        fkName = "FK_Issue_Id"
    )

    val versionId = integer("versionId").references(
        Versions.id,
        onDelete = ReferenceOption.CASCADE,
        onUpdate = ReferenceOption.CASCADE,
        fkName = "FK_Version_Id"
    )

    override val primaryKey = PrimaryKey(id, name="PK_PK_FixVersionsToIssues_ID_ID")

    fun createEntityFromRow(row: ResultRow): VersionToIssueEntity {
        return VersionToIssueEntity(
            id = row[id],
            issueId = row[issueId],
            versionId = row[versionId],
        )
    }
}