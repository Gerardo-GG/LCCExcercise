package com.ibm.lcc_template.data

import com.ibm.lcc_template.data.database.ProductDao
import com.ibm.lcc_template.data.model.Product
import com.ibm.lcc_template.data.network.StoreApi
import com.ibm.lcc_template.utils.Constants
import javax.inject.Inject

class StoreRespository @Inject constructor(
    val api: StoreApi,
    val databaseDao: ProductDao
) {

    suspend fun getAllProducts(): Array<Product> {
        val response = api.getProducts(Constants.API_LIMIT)
        return response.body() ?: emptyArray()
    }

    suspend fun insertProductShopping(item: Product) {
        databaseDao.insert(item)
    }

    suspend fun getShoppingList(): Array<Product> = databaseDao.getAllProducts()

}