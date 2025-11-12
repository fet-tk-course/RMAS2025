package com.example.positivequotessolution

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.positivequotessolution.data.DataSource
import com.example.positivequotessolution.model.Quote
import com.example.positivequotessolution.ui.theme.PositiveQuotesSolutionTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PositiveQuotesSolutionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PositiveQuotesApp()
                }
            }
        }
    }
}

@Composable
fun PositiveQuotesApp() {

    val layoutDirection = LocalLayoutDirection.current
    Surface (Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection)
            )
    ){
        QuotesList(
            DataSource().loadQuotes()
        )

    }

}

@Composable
fun QuoteCard(quote: Quote, modifier: Modifier = Modifier){
    Card(modifier = modifier) {
        Column {
            Image(
                painterResource(quote.imageResourceID),
                stringResource(quote.stringResourceID),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(quote.stringResourceID),
                modifier = Modifier
                    .padding(16.dp),
                style = MaterialTheme.typography.bodyLarge
            )

        }
    }

}

@Preview
@Composable
fun QuoteCardPreview(){
    QuoteCard(Quote(R.string.affirmation1, R.drawable.image1))
}


@Composable
fun QuotesList(quotesList: List<Quote>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(quotesList){ quote ->
            QuoteCard(
                quote, modifier = Modifier.padding(8.dp)
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun PositiveQuotesAppPreview() {
    PositiveQuotesSolutionTheme {
        PositiveQuotesApp()
    }
}