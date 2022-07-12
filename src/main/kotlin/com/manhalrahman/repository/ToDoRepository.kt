package com.manhalrahman.repository

import com.manhalrahman.entities.ToDo

interface ToDoRepository {
    fun getAtllTodos(): List<ToDo>
    fun getToDo(id: Int): ToDo?


}