package com.ibm.lcc_template.presentation

import com.ibm.lcc_template.data.model.QuestionDto

sealed class UIState {
    data class Success(val question: QuestionDto): UIState()
    data object Finished: UIState()
    data class Error(val msg: String): UIState()
    data object Loading: UIState()
}