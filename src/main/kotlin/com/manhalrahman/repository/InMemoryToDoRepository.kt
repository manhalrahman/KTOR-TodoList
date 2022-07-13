package com.manhalrahman.repository

import com.manhalrahman.entities.ToDo
import com.manhalrahman.entities.ToDoDraft
// reinstalled mac
class InMemoryToDoRepository : ToDoRepository {

    private val todos = mutableListOf<ToDo>()

    override fun getAtllTodos(): List<ToDo> {
        return todos
    }

    override fun getToDo(id: Int): ToDo? {
        return todos.firstOrNull { it.id == id }
    }

    override fun addTodo(draft: ToDoDraft): ToDo {
        val todo = ToDo(
            id = todos.size + 1,
            title = draft.title,
            done = draft.done
        )
        todos.add(todo)
        return todo
    }

    override fun removeTodo(id: Int): Boolean {
        return todos.removeIf { it.id == id }
    }

    override fun updateTodo(id: Int, draft: ToDoDraft): Boolean {
        val todo = todos.firstOrNull() ?: return false
        todo.title = draft.title
        todo.done = draft.done

        return true
    }
}