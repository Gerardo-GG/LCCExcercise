package com.ibm.lcc_template.data

import com.ibm.lcc_template.data.model.QuestionDto
import com.ibm.lcc_template.data.network.TriviaAPI
import com.ibm.lcc_template.utils.Constants
import javax.inject.Inject

class TriviaRepository @Inject constructor(
    val api: TriviaAPI
) {

    suspend fun getTriviaQuestions(): List<QuestionDto> {
        val response = api.getTriviaList(
            Constants.AMOUNT_QUERY,
            Constants.CATEGORY_QUERY,
            Constants.DIFFICULTY_QUERY,
            Constants.TYPE_QUERY
        )

        return response.body()?.results ?: emptyList()
    }

}