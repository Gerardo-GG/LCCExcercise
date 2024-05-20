package com.ibm.lcc_template.presentation.view.Question

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ibm.lcc_template.data.model.QuestionDto
import com.ibm.lcc_template.presentation.UIState
import com.ibm.lcc_template.presentation.viewmodel.TriviaViewModel

@Composable
fun QuestionScreen(viewModel: TriviaViewModel) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color((0xFFD0BCFF)))
    ) {


        when(val result = state) {
            is UIState.Error -> {}
            UIState.Finished -> {
                AlertDialog(
                    onDismissRequest = {
                    },
                    confirmButton = {
                        TextButton(onClick = {
                            viewModel.getAllQuestions()
                        }) {
                            Text(text = "Repeat")
                        }
                    },
                    title = {
                        Text(text = "Results")
                    },
                    text = {
                        Text(text = "You have ${viewModel.getCorrectAnswers()} correct answers")
                    }
                )
            }
            is UIState.Success -> {
                QuestionComponent(question = result.question, viewModel, )
            }

            UIState.Loading -> {}
        }

    }
}

@Composable
fun QuestionComponent(question: QuestionDto, viewModel: TriviaViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = question.question, modifier = Modifier.align(Alignment.CenterHorizontally))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {

            Button(onClick = {
                viewModel.validateAnswer(question, "False")
            }) {
                Text(text = "False")
            }

            Button(onClick = {
                viewModel.validateAnswer(question, "True")
            }) {
                Text(text = "True")
            }
        }
    }
}
