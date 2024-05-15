package com.ibm.lcc_template.data.network

import com.ibm.lcc_template.data.model.TodoItem
import retrofit2.Response
import retrofit2.http.GET

interface TodosAPI {

    @GET("/todos")
    suspend fun getTodos(): Response<Array<TodoItem>>

}