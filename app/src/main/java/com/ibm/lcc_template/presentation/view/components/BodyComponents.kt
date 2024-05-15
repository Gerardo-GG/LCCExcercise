package com.ibm.lcc_template.presentation.view.components

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ibm.lcc_template.data.model.TodoItem
import com.ibm.lcc_template.presentation.UIState
import com.ibm.lcc_template.presentation.viewmodel.TodosViewmodel

@Composable
fun BodyView(viewmodel: TodosViewmodel) {

    val data by viewmodel.uiState.collectAsState()
    val context = LocalContext.current as Activity

    when (val state = data) {
        is UIState.Error -> {

        }

        UIState.Loading -> {

        }

        is UIState.Success -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                items(state.response) { todoItem ->
                    var stateCompleted by remember { mutableStateOf(todoItem.completed) }

                    TodoViewItem(todoItem, stateCompleted) {
                        stateCompleted = it
                        todoItem.completed = stateCompleted
                        viewmodel.updateItem(context, todoItem)
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }

            }
        }
    }

}

@Composable
fun TodoViewItem(item: TodoItem, statusCompleted: Boolean, onCompletedSelected: (Boolean) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Text(text = item.title, modifier = Modifier.weight(1.0f))
            Checkbox(checked = statusCompleted, onCheckedChange = { onCompletedSelected(it) })
        }
    }

}




