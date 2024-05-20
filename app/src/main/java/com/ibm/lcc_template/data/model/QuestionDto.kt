package com.ibm.lcc_template.data.model

import com.google.gson.annotations.SerializedName

data class QuestionDto(
    val difficulty: String,
    val category: String,
    val question: String,
    @SerializedName("correct_answer") val correctAnswer: String,
    @SerializedName("incorrect_answer") val incorrectAnswer: List<String>
)
