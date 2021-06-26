package com.helicoptera.togerio.db.table

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object ProjectMembers : Table("ProjectMembers") {

    val id = integer("id").uniqueIndex().autoIncrement()
    val projectId = integer("projectId").references(
        Projects.id,
        onDelete = ReferenceOption.CASCADE,
        onUpdate = ReferenceOption.CASCADE,
        fkName = "FK_Project_Id"
    )
    val userId = integer("userId").references(
        Users.id,
        onDelete = ReferenceOption.CASCADE,
        onUpdate = ReferenceOption.CASCADE,
        fkName = "FK_User_Id"
    )
    val completeTaskCount = integer("completeTaskCount").default(0)
    val processingTaskCount = integer("completeTaskCount").default(0)

    override val primaryKey = PrimaryKey(id, name = "PK_ProjectMember_ID")
}