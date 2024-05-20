package com.ibm.lcc_template.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ibm.lcc_template.presentation.view.Question.QuestionScreen
import com.ibm.lcc_template.presentation.viewmodel.TriviaViewModel
import com.ibm.lcc_template.ui.theme.LCC_templateTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Api trivia
 * https://opentdb.com/api.php?amount=10&category=9&difficulty=easy&type=boolean
 * 1.    La app muestra el cuestionario.
 * 2.    El usuario responde las preguntas de “verdadero y falso”.
 * 3.    Al final se muestra la puntuación del usuario.
 */

// Work Manager
// Nueva version de navigation
// Componentes de Android

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: TriviaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getAllQuestions()

        setContent {
            LCC_templateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuestionScreen(viewModel = viewModel)
                }
            }
        }
    }
}