package com.example.htttp_and_todolist.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.htttp_and_todolist.ui.ErrorScreen
import com.example.htttp_and_todolist.ui.LoadingScreen
import com.example.htttp_and_todolist.ui.TodoList
import com.example.htttp_and_todolist.viewmodel.TodoUiState
import  com.example.htttp_and_todolist.viewmodel.TodoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoApp(todoViewModel: TodoViewModel = viewModel()) {
    Scaffold (
        topBar = {
            TopAppBar(
                title={Text("Todos")}
            )
        }
    )
    { innerPadding ->
        TodoScreen(Modifier.padding(innerPadding),todoViewModel.todoUiState)

    }
}

@Composable
fun TodoScreen(modifier: Modifier, uiState: TodoUiState) {
    Log.d("todos todos screens",uiState.toString())
    when (uiState) {
        is TodoUiState.Loading -> LoadingScreen(modifier)
        is TodoUiState.Success -> TodoList(modifier,uiState.todos)
        is TodoUiState.Error -> ErrorScreen(modifier)
    }
}