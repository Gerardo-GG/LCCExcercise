package com.ibm.lcc_template.domain

import android.content.Context
import com.ibm.lcc_template.data.TodosRepository
import com.ibm.lcc_template.data.database.TodoDatabase
import com.ibm.lcc_template.data.model.TodoItem

class GetTodosUseCase(
    private var room: TodoDatabase
) {

    private val repository = TodosRepository(room)

    suspend operator fun invoke(): Array<TodoItem> = repository.getAllTodos()

}