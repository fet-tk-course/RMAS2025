package com.example.navigationexample2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationexample2.ui.theme.NavigationExample2Theme

const val ROUTE_HOME = "home"
const val ROUTE_DETAILS = "details"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationExampleApp2()
            }
        }
    }

@Composable
fun NavigationExampleApp2(modifier: Modifier = Modifier) {
    NavigationExample2Theme {
        val navController = rememberNavController()
        val viewModel: ExViewModel = viewModel()

        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->

            NavHost(
                navController = navController,
                startDestination = ROUTE_HOME,
                modifier = Modifier.padding(innerPadding)
            ) {

                composable(ROUTE_HOME) {
                    HomeScreen(
                        uiState = viewModel.uiState,
                        onNameChanged = { viewModel.updateName(it)},
                        onDetailsClicked = {
                            navController.navigate(ROUTE_DETAILS)
                        }
                    )

                }
                composable(ROUTE_DETAILS) {
                    Details(
                        name = viewModel.uiState.name,
                        onBackClicked = {
                            navController.popBackStack()
                        }
                    )

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NavigationExample2Preview() {
    NavigationExampleApp2()
}