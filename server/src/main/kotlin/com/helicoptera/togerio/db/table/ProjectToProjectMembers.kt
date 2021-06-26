package com.helicoptera.togerio.db.table

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object ProjectToProjectMembers : Table("Project2ProjectMembers") {

    val id = integer("id").uniqueIndex().autoIncrement()
    val projectId = integer("projectId").references(
        Projects.id,
        onDelete = ReferenceOption.CASCADE,
        onUpdate = ReferenceOption.CASCADE,
        fkName = "FK_Project_Id"
    )
    val projectMemberId = integer("projectMemberId").references(
        Projects.id,
        onDelete = ReferenceOption.CASCADE,
        onUpdate = ReferenceOption.CASCADE,
        fkName = "FK_ProjectMember_Id"
    )

    override val primaryKey = PrimaryKey(Projects.id, name = "PK_Project2ProjectMembers_ID")
}