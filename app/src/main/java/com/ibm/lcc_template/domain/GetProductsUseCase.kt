package com.ibm.lcc_template.domain

import com.ibm.lcc_template.data.StoreRespository
import com.ibm.lcc_template.data.model.Product
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    val repository: StoreRespository
) {
    // Mapper, capa modelo
    // Uso de array o list

    suspend operator fun invoke(): Array<Product> = repository.getAllProducts()

}