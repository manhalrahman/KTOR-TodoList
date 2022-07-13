package com.manhalrahman.repository

import com.manhalrahman.database.DatabaseManager
import com.manhalrahman.entities.ToDo
import com.manhalrahman.entities.ToDoDraft

class MySQLTodoRepository : ToDoRepository {

    private val database = DatabaseManager()

    override fun getAllTodos(): List<ToDo> {
        return database.getAllTodos().map {
            ToDo(it.id, it.title, it.done)
        }
    }

    override fun getToDo(id: Int): ToDo? {
        return database.getTodo(id)
            ?.let{
                ToDo(it.id, it.title, it.done)
            }
    }

    override fun addTodo(draft: ToDoDraft): ToDo {
        return database.addTodo(draft)
    }

    override fun removeTodo(id: Int): Boolean {
        return database.removeTodo(id)
    }

    override fun updateTodo(id: Int, draft: ToDoDraft): Boolean {
        return database.updateTodo(id, draft)
    }
}