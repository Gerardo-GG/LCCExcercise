package com.ibm.lcc_template.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibm.lcc_template.data.model.QuestionDto
import com.ibm.lcc_template.domain.GetTriviaUseCase
import com.ibm.lcc_template.presentation.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TriviaViewModel @Inject constructor(
    private val triviaUseCase: GetTriviaUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<UIState>(UIState.Loading)
    val uiState = _uiState

    private lateinit var listQuestions: List<QuestionDto>
    private var counter = 0

    private var correctAnswers = 0

    fun getAllQuestions() {
        correctAnswers = 0
        viewModelScope.launch {
            val response = triviaUseCase()

            if (response.isEmpty()) {
                _uiState.value = UIState.Error("Error")
            } else {
                listQuestions = response
                getNextQuestion()
            }
        }
    }

    private fun getNextQuestion() {
        if (counter == listQuestions.size) {
            _uiState.value = UIState.Finished
        } else {
            _uiState.value = UIState.Success(listQuestions[counter])
            counter ++
        }
    }

    fun validateAnswer(questionDto: QuestionDto, response: String) {
        if (questionDto.correctAnswer == response) {
            correctAnswers ++
        }
        getNextQuestion()
    }

    fun getCorrectAnswers(): Int = correctAnswers


}