package com.ibm.lcc_template.presentation

import com.ibm.lcc_template.data.model.TodoItem

sealed class UIState {
    data class Success(val response: Array<TodoItem>): UIState()
    data class Error(val msg: String, val ex: Exception? = null): UIState()
    object Loading: UIState()
}