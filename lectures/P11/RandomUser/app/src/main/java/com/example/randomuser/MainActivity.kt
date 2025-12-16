package com.example.randomuser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.randomuser.ui.RandomUserUiState
import com.example.randomuser.ui.theme.RandomUserTheme
import com.example.randomuser.ui.RandomUserVIewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val viewModel = remember { RandomUserVIewModel() }
            val uiState by viewModel.uiState.collectAsState()

            RandomUserScreen(
                uiState = uiState,
                onLoadClicked = {
                    viewModel.loadRandomUsers(2)
                }
            )
        }
    }
}

@Composable
fun RandomUserScreen(
    uiState: RandomUserUiState,
    onLoadClicked: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)){
        Button(onLoadClicked) {Text("Load users") }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Users count: ${uiState.users.size}")

        Spacer(modifier = Modifier.height(16.dp))
        when{
            uiState.isLoading -> {
                Text("Loading...")
            }
            uiState.errorMessage != null -> {
                Text("Error: ${uiState.errorMessage}")
            }
            else -> {
                uiState.users.forEachIndexed { index, user ->
                    Text("User #${index+1}")
                    Text("name: ${user.name}")
                    Text("country: ${user.country}")

                    AsyncImage(
                        model = user.avatar,
                        contentDescription = "Profile picture of ${user.name}",
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)

                    )
                    Spacer(modifier = Modifier.height(16.dp))

                }
            }
        }
    }

}

