package com.example.htttp_and_todolist.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.htttp_and_todolist.ui.theme.Htttp_and_todolistTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.htttp_and_todolist.ui.screens.TodoApp
import com.example.htttp_and_todolist.viewmodel.Todo


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Htttp_and_todolistTheme {
                TodoApp()
            }
        }
    }
}


@Composable
fun TodoList(modifier: Modifier = Modifier, todos: List<Todo>) {
    LazyColumn (
        modifier = modifier
    )
    {
        items(todos) { todo ->
            Text(
                text = todo.title,
                modifier = Modifier.padding(top=4.dp,bottom=4.dp)
            )
            HorizontalDivider(color = Color.LightGray, thickness = 2.dp)
        }
    }
}

@Composable
fun ErrorScreen(modifier: Modifier) {
    Text("Error retrieving data from API.", modifier = modifier)
}


@Composable
fun LoadingScreen(modifier: Modifier) {
    Text("Loading...", modifier = modifier)

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Htttp_and_todolistTheme {
        TodoApp()
    }
}