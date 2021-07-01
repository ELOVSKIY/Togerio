package com.helicoptera.togerio.db.transaction

import com.helicoptera.togerio.data.entity.User
import com.helicoptera.togerio.db.table.Users
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.lang.IllegalStateException

fun insertUser(user: User) : User{
    transaction {
        Users.insert {
            it[username] = user.username
            it[password] = md5(user.password)
        }
    }

    return fetchUserByUsername(user.username) ?: throw IllegalStateException()
}

fun fetchUserByUsername(username: String): User? {
    val resultRow = transaction {
        Users.select {
            Users.username eq username
        }.firstOrNull()
    }

    return if (resultRow != null) Users.toUserModel(resultRow) else null
}

fun fetchUserByUserId(id: Int): User? {
    val resultRow = transaction {
        Users.select {
            Users.id eq id
        }.firstOrNull()
    }

    return if (resultRow != null) Users.toUserModel(resultRow) else null
}