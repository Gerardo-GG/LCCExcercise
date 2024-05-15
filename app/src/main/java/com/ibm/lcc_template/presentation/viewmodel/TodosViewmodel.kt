package com.ibm.lcc_template.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibm.lcc_template.data.model.TodoItem
import com.ibm.lcc_template.domain.GetTodosUseCase
import com.ibm.lcc_template.domain.UpdateTodoUseCase
import com.ibm.lcc_template.presentation.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class TodosViewmodel(
    private val getTodosUseCase: GetTodosUseCase,
    private val updateUseCase: UpdateTodoUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<UIState>(UIState.Loading)
    var uiState = _uiState

    fun getAllTodos() {
        _uiState.value = UIState.Loading
        viewModelScope.launch {
            val response = getTodosUseCase()

            if (response.isEmpty()) {
                _uiState.value = UIState.Error("Error")
            } else {
                _uiState.value = UIState.Success(response)
            }
            return@launch
        }
    }

    fun updateItem(context: Context, item: TodoItem){
        viewModelScope.launch {
            updateUseCase(context, item)
        }
    }

}