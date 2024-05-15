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
import com.ibm.lcc_template.LCCApplication
import com.ibm.lcc_template.data.network.TodosAPI
import com.ibm.lcc_template.domain.GetTodosUseCase
import com.ibm.lcc_template.domain.UpdateTodoUseCase
import com.ibm.lcc_template.presentation.view.components.BodyView
import com.ibm.lcc_template.presentation.viewmodel.TodosViewmodel
import com.ibm.lcc_template.ui.theme.LCC_templateTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Api To-DO
 * https://jsonplaceholder.typicode.com/todos
 * 1.    Mostrar lista de tareas
 *  d.    Titulo
 *  e.    Estado de completado
 * 2.    Alternar estado de tareas entre pendiente y completado
 * 3.    Refrescar lista de tareas
 * 4.    Mantener estado de finalizadon de las tareas
 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: TodosViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getAllTodos()

        setContent {
            LCC_templateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BodyView(viewModel)
                }
            }
        }
    }
}

