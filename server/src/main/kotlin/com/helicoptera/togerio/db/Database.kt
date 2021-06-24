package com.helicoptera.togerio.db

import com.helicoptera.togerio.db.table.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun initDB(testing: Boolean) {
    Database.connect("jdbc:h2:./myh2file", "org.h2.Driver")
    dropSchemas()
    createSchemas()
}

private fun dropSchemas() {
    transaction {
        SchemaUtils.drop(Users)
    }
}

private fun createSchemas() {
    transaction {
        SchemaUtils.create(Users)
    }
}