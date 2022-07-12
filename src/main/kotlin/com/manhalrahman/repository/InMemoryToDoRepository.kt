package com.manhalrahman.repository

import com.manhalrahman.entities.ToDo

class InMemoryToDoRepository : ToDoRepository {

    val todos = listOf<ToDo>(
        ToDo(1, "Plan content for video #2", true),
        ToDo(2, "Record video #2", false),
        ToDo(3, "Upload Video #2", false)
    )

    override fun getAtllTodos(): List<ToDo> {
        return todos
    }

    override fun getToDo(id: Int): ToDo? {
        return todos.firstOrNull { it.id == id }
    }
}