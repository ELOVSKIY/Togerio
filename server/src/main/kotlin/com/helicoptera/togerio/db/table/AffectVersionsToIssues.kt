package com.helicoptera.togerio.db.table

import com.helicoptera.togerio.data.entity.project.issue.PriorityEntity
import com.helicoptera.togerio.data.entity.project.issue.VersionToIssueEntity
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object AffectVersionsToIssues : Table("AffectVersionsToIssues") {

    val id = integer("id").uniqueIndex().autoIncrement()
    val issueId = integer("issueId").references(
        Issues.id,
        onDelete = ReferenceOption.CASCADE,
        onUpdate = ReferenceOption.CASCADE,
        fkName = "FK_AffectVersion_Issue_Id"
    )

    val versionId = integer("versionId").references(
        Versions.id,
        onDelete = ReferenceOption.CASCADE,
        onUpdate = ReferenceOption.CASCADE,
        fkName = "FK_Issue_AffectVersion_Id"
    )

    override val primaryKey = PrimaryKey(id, name="PK_AffectVersionsToIssues_ID")

    fun createEntityFromRow(row: ResultRow): VersionToIssueEntity {
        return VersionToIssueEntity(
            id = row[id],
            issueId = row[issueId],
            versionId = row[versionId],
        )
    }
}