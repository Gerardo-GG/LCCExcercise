package com.ibm.lcc_template.data.network

import com.ibm.lcc_template.data.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StoreApi {

    @GET("/products")
    suspend fun getProducts(@Query("limit") limit: Int): Response<Array<Product>>

}