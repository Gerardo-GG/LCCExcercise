package com.ibm.lcc_template.presentation

import com.ibm.lcc_template.data.model.Product

// Data class
sealed class UIState {
    data class Success(val response: Array<Product>): UIState()
    data class Error(val msg: String): UIState()
    data object Loading: UIState()
}