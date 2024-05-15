package com.ibm.lcc_template.data

import android.app.Application
import android.content.Context
import com.ibm.lcc_template.LCCApplication
import com.ibm.lcc_template.data.database.TodoDBDao
import com.ibm.lcc_template.data.database.TodoDatabase
import com.ibm.lcc_template.data.model.TodoItem
import com.ibm.lcc_template.data.network.TodosAPIService
import javax.inject.Inject

class TodosRepository @Inject constructor(
    private val api: TodosAPIService,
    private val todoDao: TodoDBDao
) {

    suspend fun getAllTodos(): Array<TodoItem> {
        val response = api.getAllTodos()

        todoDao.insert(response)

        response.map {
            val newData = todoDao.getData(it.id)
            if (newData != null) {
                it.completed = newData.completed
            }
        }

        return response
    }

    suspend fun updateTodoItem(item: TodoItem) {
        todoDao.update(item)
    }

}