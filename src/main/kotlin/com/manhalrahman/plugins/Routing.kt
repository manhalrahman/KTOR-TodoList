package com.manhalrahman.plugins

import com.manhalrahman.entities.ToDo
import com.manhalrahman.repository.InMemoryToDoRepository
import com.manhalrahman.repository.ToDoRepository
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
            setPrettyPrinting()
        }
    }
    routing {
        val repository: ToDoRepository = InMemoryToDoRepository()

        get("/") {
            call.respondText("Hello TODOList!")
        }

        get("/todos") {
            call.respond(repository.getAtllTodos())

        }

        get("/todos/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()

            if (id == null) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    "id parameter must be an number"
                )
                return@get
            }

            val todo = repository.getToDo(id)

            if (todo == null) {
                call.respond(
                    HttpStatusCode.NotFound,
                    "found no todo for the the provided $id"
                )
            } else {
                call.respond(todo)

            }

        }


        //TODO

        post("/todos") {

        }

        post("/todos/{id}") {

        }

        delete("/todos/{id}") {

        }
    }

}
