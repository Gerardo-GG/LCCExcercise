package com.ibm.lcc_template.domain

import android.content.Context
import com.ibm.lcc_template.data.TodosRepository
import com.ibm.lcc_template.data.database.TodoDatabase
import com.ibm.lcc_template.data.model.TodoItem
import javax.inject.Inject

class UpdateTodoUseCase @Inject constructor(
    private val repository: TodosRepository
) {

    suspend operator fun invoke(item: TodoItem) {
        repository.updateTodoItem(item)
    }
}