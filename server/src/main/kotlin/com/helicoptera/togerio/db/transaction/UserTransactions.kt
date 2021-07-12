package com.helicoptera.togerio.db.transaction

import com.helicoptera.togerio.data.entity.UserEntity
import com.helicoptera.togerio.db.table.Users
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun insertUser(userEntity: UserEntity) : UserEntity{
    transaction {
        Users.insert {
            it[username] = userEntity.username
            it[password] = md5(userEntity.password)
        }
    }

    return fetchUserByUsername(userEntity.username) ?: throw IllegalStateException()
}

fun fetchUserByUsername(username: String): UserEntity? {
    val resultRow = transaction {
        Users.select {
            Users.username eq username
        }.firstOrNull()
    }

    return if (resultRow != null) Users.createEntityFromRow(resultRow) else null
}

fun fetchUserByUserId(id: Int): UserEntity? {
    val resultRow = transaction {
        Users.select {
            Users.id eq id
        }.firstOrNull()
    }

    return if (resultRow != null) Users.createEntityFromRow(resultRow) else null
}