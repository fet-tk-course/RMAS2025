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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
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
fun TextAboveButtons(
    countViewModel: CountViewModel = viewModel(),
    modifier:Modifier = Modifier.padding(10.dp)){

    //var count by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center, // centers everything vertically on screen
        horizontalAlignment = Alignment.CenterHorizontally // centers text and row horizontally
    ) {
        Text(text = stringResource(R.string.count, countViewModel.count))

        Spacer(modifier = Modifier.height(16.dp)) // space between text and buttons

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp), // space between buttons
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { /* action 1 */
                countViewModel.increment()
            }) {
                Text("+")
            }
            Button(onClick = { /* action 2 */
                countViewModel.decrement()
            }) {
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