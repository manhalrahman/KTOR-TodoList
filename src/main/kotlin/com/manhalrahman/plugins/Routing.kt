package com.manhalrahman.plugins

import com.manhalrahman.entities.ToDo
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {

    install(CallLogging) // to track activity in terminal
    // Starting point for a Ktor app:

    install(ContentNegotiation) {
        gson {


        }
    }
    routing {

        val todos = listOf<ToDo>(
            ToDo(1, "Plan content for video #2", true),
            ToDo(2, "Record video #2", false),
            ToDo(3, "Upload Video #2", false)
        )

        get("/") {
            call.respondText("Hello TODOList!")
        }

        get("/todos") {
            call.respond(todos)

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

}
