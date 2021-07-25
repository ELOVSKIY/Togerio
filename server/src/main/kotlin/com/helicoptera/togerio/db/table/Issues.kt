package com.helicoptera.togerio.db.table

import com.helicoptera.togerio.data.entity.project.issue.IssueEntity
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object Issues : Table("Issues") {

    val id = Issues.integer("id").uniqueIndex().autoIncrement()
    val title = Issues.varchar("title", length = 255).uniqueIndex()
    val description = Issues.varchar("description", length = 255)
    val code = Issues.varchar("code", length = 255).uniqueIndex()
    val number = Issues.integer("number")

    val projectId = integer("projectId").references(
        Projects.id,
        onDelete = ReferenceOption.CASCADE,
        onUpdate = ReferenceOption.CASCADE,
        fkName = "FK_Issue_Project_Id"
    )

    val priorityId = integer("priorityId").references(
        Priorities.id,
        onDelete = ReferenceOption.SET_NULL,
        onUpdate = ReferenceOption.SET_NULL,
        fkName = "FK_Issue_Priority_Id"
    )

    val typeId = integer("typeId").references(
        Types.id,
        onDelete = ReferenceOption.SET_NULL,
        onUpdate = ReferenceOption.SET_NULL,
        fkName = "FK_Issue_Type_Id"
    )

    val stateId = integer("stateId").references(
        States.id,
        onDelete = ReferenceOption.SET_NULL,
        onUpdate = ReferenceOption.SET_NULL,
        fkName = "FK_Issue_State_Id"
    )

    override val primaryKey = PrimaryKey(id, name = "PK_Issue_ID")

    fun toProjectModel(row: ResultRow): IssueEntity {
        return IssueEntity(
            id = row[id],
            title = row[title],
            description = row[description],
            number = row[number],
            code = row[code],
            projectId =  row[projectId],
            priorityId = row[priorityId],
            typeId = row[typeId],
            stateId = row[stateId]
        )
    }
}