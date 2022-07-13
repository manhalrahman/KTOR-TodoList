package com.manhalrahman.plugins

import com.manhalrahman.entities.ToDo
import com.manhalrahman.entities.ToDoDraft
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


        post("/todos") {
            val todoDraft = call.receive<ToDoDraft>()
            val todo = repository.addTodo(todoDraft)
            call.respond(todo)
        }

        put("/todos/{id}") {
            val todoDraft = call.receive<ToDoDraft>()
            val todoId = call.parameters["id"]?.toIntOrNull()


            if (todoId == null) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    "id parameter has to be a number!"
                )
                return@put
            }

            val updated = repository.updateTodo(todoId, todoDraft)

            if (updated) {
                call.respond(HttpStatusCode.OK)
            } else {
                call.respond(
                    HttpStatusCode.NotFound,
                    "found no todo with the id $todoId"
                )
            }
        }

        delete("/todos/{id}") {
            val todoId = call.parameters["id"]?.toIntOrNull()

            if (todoId == null) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    "id parameter has to be a number!"
                )
                return@delete
            }

            val removed = repository.removeTodo(todoId)
            if (removed) {
                call.respond(HttpStatusCode.OK)
            } else {
                call.respond(
                    HttpStatusCode.NotFound,
                    "found no todo with id $todoId"
                )
            }
        }

    }
}
