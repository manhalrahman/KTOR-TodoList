package com.manhalrahman.repository

import com.manhalrahman.database.DatabaseManager
import com.manhalrahman.entities.ToDo
import com.manhalrahman.entities.ToDoDraft

class MySQLTodoRepository : ToDoRepository {

    private val database = DatabaseManager()

    override fun getAtllTodos(): List<ToDo> {
        return database.getAllTodos().map {
            ToDo(it.id, it.title, it.done)
        }
    }

    override fun getToDo(id: Int): ToDo? {
        TODO("Not yet implemented")
    }

    override fun addTodo(draft: ToDoDraft): ToDo {
        TODO("Not yet implemented")
    }

    override fun removeTodo(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun updateTodo(id: Int, draft: ToDoDraft): Boolean {
        TODO("Not yet implemented")
    }
}