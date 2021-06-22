package com.helicoptera.togerio.db.transaction

import com.helicoptera.togerio.data.model.User
import com.helicoptera.togerio.db.table.Users
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun registration(user: User) {
    transaction {
        Users.insert {
            it[username] = user.username
            it[password] = md5(user.password)
        }
    }
}

fun fetchUserByUsername(username: String): User? {
    val resultRow = transaction {
        Users.select {
            Users.username eq username
        }.toList()
    }.firstOrNull()

    return if (resultRow != null) Users.toUserModel(resultRow) else null
}

fun fetchUserByUserId(userId: Int): User? {
    val resultRow = transaction {
        Users.select {
            Users.id eq userId
        }.toList()
    }.firstOrNull()

    return if (resultRow != null) Users.toUserModel(resultRow) else null
}