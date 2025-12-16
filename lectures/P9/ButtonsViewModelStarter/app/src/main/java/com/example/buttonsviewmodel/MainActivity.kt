package com.example.buttonsviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buttonsviewmodel.ui.theme.ButtonsViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ButtonsViewModelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TextAboveButtons(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TextAboveButtons(modifier:Modifier = Modifier.padding(10.dp)){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center, // centers everything vertically on screen
        horizontalAlignment = Alignment.CenterHorizontally // centers text and row horizontally
    ) {
        Text(text = stringResource(R.string.count, 0))

        Spacer(modifier = Modifier.height(16.dp)) // space between text and buttons

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp), // space between buttons
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { /* action 1 */ }) {
                Text("+")
            }
            Button(onClick = { /* action 2 */ }) {
                Text("-")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun TextAboveButtonsPreview() {
    ButtonsViewModelTheme {
        TextAboveButtons()
    }
}