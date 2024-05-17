package com.ibm.lcc_template.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibm.lcc_template.data.model.Product
import com.ibm.lcc_template.domain.GetProductsUseCase
import com.ibm.lcc_template.domain.GetShoppingListUseCase
import com.ibm.lcc_template.domain.InsertProductUseCase
import com.ibm.lcc_template.presentation.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    val getProductsUseCase: GetProductsUseCase,
    val getShoppingListUseCase: GetShoppingListUseCase,
    val insertProductUseCase: InsertProductUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<UIState>(UIState.Loading)
    val uiState = _uiState

    fun getAllProducts() {

        _uiState.value = UIState.Loading
        viewModelScope.launch {
            val response = getProductsUseCase()

            if (response.isEmpty()) {
                _uiState.value = UIState.Error("Error")
            } else {
                _uiState.value = UIState.Success(response)
            }

            return@launch
        }

    }


    fun insertProductShopping(item: Product) {

        viewModelScope.launch {
            insertProductUseCase(item)
        }

    }

}