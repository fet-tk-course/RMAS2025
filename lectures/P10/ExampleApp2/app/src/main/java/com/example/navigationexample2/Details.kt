package com.example.navigationexample2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Details(
    name: String,
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Dobrodošao $name!")
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onBackClicked
        ) {
            Text("Nazad")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DetailsPreview(){
    Details(name = "Alma",
        onBackClicked = {})
}