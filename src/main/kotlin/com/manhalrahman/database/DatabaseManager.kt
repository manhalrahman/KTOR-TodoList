package com.manhalrahman.database

import org.ktorm.database.Database

class DatabaseManager {
    // config

    private val hostname = "0.0.0.0"
    private val databaseName = "ktor_todo" // schema name basically
    private val username = "root"
    private val password = "8tqj6kjs"

    private val ktormDatabase: Database

    init {

        val jdbcUrl = "jdbc:mysql://$hostname:3306/$databaseName?user=$username&allowPublicKeyRetrieval=true&password=$password&useSSL=false"
        ktormDatabase = Database.connect(jdbcUrl)
    }


}