package com.ibm.lcc_template.data

import android.app.Application
import android.content.Context
import com.ibm.lcc_template.LCCApplication
import com.ibm.lcc_template.data.database.TodoDatabase
import com.ibm.lcc_template.data.model.TodoItem
import com.ibm.lcc_template.data.network.TodosAPIService

class TodosRepository(
    private var room: TodoDatabase
) {

    private val api = TodosAPIService()


    suspend fun getAllTodos(): Array<TodoItem> {
        val response = api.getAllTodos()

        // Create DB
        room.interfaceDao().insert(response)

        response.map {
            val newData = room.interfaceDao().getData(it.id)
            if (newData != null) {
                it.completed = newData.completed
            }
        }


        return response
    }

    suspend fun updateTodoItem(item: TodoItem, context: Context) {
        val appContext = context.applicationContext as LCCApplication
        appContext.room.interfaceDao().update(item)
    }

}