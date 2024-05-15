package com.ibm.lcc_template.domain

import android.content.Context
import com.ibm.lcc_template.data.TodosRepository
import com.ibm.lcc_template.data.database.TodoDatabase
import com.ibm.lcc_template.data.model.TodoItem
import javax.inject.Inject

class GetTodosUseCase @Inject constructor(
    private val repository: TodosRepository
) {

    suspend operator fun invoke(): Array<TodoItem> = repository.getAllTodos()

}