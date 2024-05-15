package com.ibm.lcc_template.data.network

import com.ibm.lcc_template.data.model.TodoItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class TodosAPIService @Inject constructor(
    private val apiClient: TodosAPI
) {

    suspend fun getAllTodos(): Array<TodoItem> {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getTodos()
            response.body() ?: emptyArray()
        }
    }

}