package com.example.p11example1

import android.os.Bundle
import android.util.Log
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.p11example1.ui.theme.P11Example1Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.log
import kotlin.system.measureTimeMillis


const val RESULT_1 = "Result #1"
const val RESULT_2 = "Result #2"

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoroutineDemoScreen()
        }
    }
}

private suspend fun fakeApiRequest(): String{
    return getResult1FromApi()
}

@Composable
fun CoroutineDemoScreen() {
    var status by remember{ mutableStateOf("u mirovanju") }
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = status, style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                scope.launch {
                    status = "Sekvencijalni pozivi..."
                    val time = measureTimeMillis {
                        val result1 = withContext(Dispatchers.IO){
                           getResult1FromApi()
                        }
                        val result2 = withContext(Dispatchers.IO){
                            getResult2FromApi()
                        }
                        status = "Sekvencijalno $result1, $result2"
                    }
                    Log.d("P11", "Sekvencijalno trajanje ${time}ms")
                }

            }
        ) {
            Text(text = "Sekvencijalni pozivi")
        }


        Button(
            onClick = {
                scope.launch {
                    status = "Konkuretni pozivi"
                    val time = measureTimeMillis {

                        val deferred1 = async(Dispatchers.IO) { getResult1FromApi() }
                        val deferred2 = async(Dispatchers.IO) { getResult2FromApi() }

                        val result1 = deferred1.await()
                        val result2 = deferred2.await()

                        status = "Paralelno $result1, $result2"
                    }
                    Log.d("P11", "Paralelno vrijeme: ${time}ms")
                }

                //fakeApiRequest()
                /*status = "Radi (blokira glavni thread)"
                Thread.sleep(3000)
                status = "Završeno!"*/
            }
        ) {
            Text("Konkuretni pozivi")
        }
    }

}

suspend fun getResult1FromApi(): String{
    logThread("getResult1FromApi")
    delay(1000)
    return RESULT_1
}

suspend fun getResult2FromApi(): String{
    logThread("getResult2FromApi")
    delay(2000)
    return RESULT_2
}

private fun logThread(methodName: String){
    Log.d("P11", "debug: ${methodName}: ${Thread.currentThread().name}")
}


@Preview(showBackground = true)
@Composable
fun CoroutineDemoScreenPreview() {
        CoroutineDemoScreen()
}