package com.example.p6solution

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.referentialEqualityPolicy
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.p6solution.ui.theme.P6solutionTheme
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            P6solutionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    TipLayout()
                }
            }
        }
    }
}

@Composable
fun TipLayout(modifier: Modifier = Modifier) {
    var amountInput by remember{ mutableStateOf("") }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount)

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        EditTextField(
            value = amountInput,
            onValueChange = {amountInput = it},
            modifier = Modifier.padding(bottom = 20.dp).fillMaxWidth())
        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun EditTextField(
    value: String,
    onValueChange : (String) -> Unit,
    modifier: Modifier = Modifier){
    TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = {Text(text = stringResource(R.string.bill_amount))},
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun TipLayoutPreview() {
    P6solutionTheme {
        TipLayout()
    }
}

/**
 * Računa napojnicu na osnovu iznosa koji je korisnik unio
 * i prikazuje rezultat u konvertibilnim markama (KM).
 * Primjer izlaza: "10.00 KM"
 */
private fun calculateTip(amount: Double, tipPercent: Double = 15.0): String {
    val tip = tipPercent / 100 * amount
    // Kreiramo format za prikaz valute u KM (konvertibilnim markama)
    val format = NumberFormat.getCurrencyInstance(Locale("bs", "BA"))
    format.currency = Currency.getInstance("BAM")
    return format.format(tip)
}
