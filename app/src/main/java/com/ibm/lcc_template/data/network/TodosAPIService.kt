package com.ibm.lcc_template.data.network

import com.ibm.lcc_template.core.RetrofitHelper
import com.ibm.lcc_template.data.model.TodoItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodosAPIService {

    private var retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllTodos(): Array<TodoItem> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(TodosAPI::class.java).getTodos()
            response.body() ?: emptyArray()
        }
    }

}