package com.example.layoutprojectedu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.layoutprojectedu.ui.theme.LayoutProjectEduTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutProjectEduTheme {
                TestLazyColumn()
            }
        }
    }
}

@Composable
fun TestColumn(modifier: Modifier = Modifier){
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color.Blue)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ){
        Text(text = "1")
        Text(text = "2")
        Text(text = "3")
    }
}

@Composable
fun TestRow(modifier: Modifier = Modifier){
    Row (
        modifier = modifier.fillMaxSize().background(Color.Blue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(30.dp)
    ){
        Text(text = "1")
        Text(text = "2")
        Text(text = "3")
    }
}

data class Friend(
    val name: String,
    val age: Int,
)

@Composable
fun TestLazyColumn(modifier: Modifier = Modifier){
    val friends = listOf(
        Friend("John", 25),
        Friend("Jane", 30),
        Friend("Bob", 35),
        Friend("Alice", 40),
    )
    LazyColumn (
        modifier = modifier
            .fillMaxSize()
            .background(Color.Green),
    ){
        items(friends){friend ->
            Text(text = "${friend.name} is ${friend.age} years old")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LayoutProjectEduTheme {
        TestLazyColumn()
    }
}