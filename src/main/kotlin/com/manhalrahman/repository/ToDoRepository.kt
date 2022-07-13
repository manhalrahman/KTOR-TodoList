package com.manhalrahman.repository

import com.manhalrahman.entities.ToDo
import com.manhalrahman.entities.ToDoDraft

interface ToDoRepository {
    fun getAllTodos(): List<ToDo>
    fun getToDo(id: Int): ToDo?
    fun addTodo(draft: ToDoDraft): ToDo

    fun removeTodo(id: Int) : Boolean

    fun updateTodo(id: Int, draft: ToDoDraft) : Boolean

}