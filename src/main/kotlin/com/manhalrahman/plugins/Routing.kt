package com.manhalrahman.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondText("Hello TODOList!")
        }

        get("/todos") {

        }

        get("/todos/{id}") {
            val id = call.parameters["id"]
            call.respondText("TODOList Details for ToDo item #$id")

        }

        post("/todos") {

        }

        post("/todos/{id}") {

        }

        delete("/todos/{id}") {

        }
    }
    routing {
    }
}
