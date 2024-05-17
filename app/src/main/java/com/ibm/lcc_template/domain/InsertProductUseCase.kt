package com.ibm.lcc_template.domain

import com.ibm.lcc_template.data.StoreRespository
import com.ibm.lcc_template.data.model.Product
import javax.inject.Inject

class InsertProductUseCase @Inject constructor(
    val repository: StoreRespository
) {

    suspend operator fun invoke(item: Product) = repository.insertProductShopping(item)

}