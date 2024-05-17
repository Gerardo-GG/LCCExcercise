package com.ibm.lcc_template.domain

import com.ibm.lcc_template.data.StoreRespository
import com.ibm.lcc_template.data.model.Product
import javax.inject.Inject

class GetShoppingListUseCase @Inject constructor(
    val repository: StoreRespository
) {

    suspend operator fun invoke(): Array<Product> = repository.getShoppingList()

}