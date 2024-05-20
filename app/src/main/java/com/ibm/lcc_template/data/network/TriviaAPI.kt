package com.ibm.lcc_template.data.network

import com.ibm.lcc_template.data.model.TriviaResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaAPI {

    @GET("/api.php")
    suspend fun getTriviaList(
        @Query("amount") amount: String,
        @Query("category") category: String,
        @Query("difficulty") difficulty: String,
        @Query("type") type: String
    ): Response<TriviaResponse>

}