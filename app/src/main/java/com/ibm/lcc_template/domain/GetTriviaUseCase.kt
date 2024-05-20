package com.ibm.lcc_template.domain

import com.ibm.lcc_template.data.TriviaRepository
import com.ibm.lcc_template.data.model.QuestionDto
import javax.inject.Inject

class GetTriviaUseCase @Inject constructor(
    private val repository: TriviaRepository
) {

    suspend operator fun invoke(): List<QuestionDto> = repository.getTriviaQuestions()
}