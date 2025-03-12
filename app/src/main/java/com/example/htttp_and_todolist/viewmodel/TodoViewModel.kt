package com.example.htttp_and_todolist.viewmodel

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

sealed interface TodoUiState {
    data class Success(val todos: List<Todo>): TodoUiState
    data object Error: TodoUiState
    data object Loading: TodoUiState
}

class TodoViewModel: ViewModel() {
    var todoUiState: TodoUiState by
    mutableStateOf<TodoUiState>(TodoUiState.Loading)
        private set

    init {
        getTodosList()
    }



    private fun getTodosList() {
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi.getInstance()
                todoUiState = TodoUiState.Success(todosApi.getTodos())
                Log.d("todos", todoUiState.toString())
            } catch (e: Exception) {
                todoUiState = TodoUiState.Error
                Log.d("todos", todoUiState.toString())
                Log.d("todosViewModel","error fetching todos: ${e.message}")
            }
        }
    }
}