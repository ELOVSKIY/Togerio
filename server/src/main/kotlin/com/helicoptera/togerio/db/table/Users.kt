package com.helicoptera.togerio.db.table

import com.helicoptera.togerio.data.entity.UserEntity
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object Users : Table("Users") {

    val id = integer("id").uniqueIndex().autoIncrement()
    val username = varchar("username", length = 255).uniqueIndex()
    val password = varchar("password", length = 255)

    override val primaryKey = PrimaryKey(id, name="PK_User_ID")

    fun createEntityFromRow(row: ResultRow): UserEntity {
        return UserEntity(
            id = row[id],
            username = row[username],
            password = row[password]
        )
    }
}
