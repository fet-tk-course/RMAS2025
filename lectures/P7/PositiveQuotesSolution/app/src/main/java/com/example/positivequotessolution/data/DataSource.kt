package com.example.positivequotessolution.data

import com.example.positivequotessolution.R
import com.example.positivequotessolution.model.Quote


class DataSource {
    fun loadQuotes(): List<Quote> {
        return listOf<Quote>(
            Quote(R.string.affirmation1,R.drawable.image1),
            Quote(R.string.affirmation2,R.drawable.image2),
            Quote(R.string.affirmation3,R.drawable.image3),
            Quote(R.string.affirmation4,R.drawable.image4),
            Quote(R.string.affirmation5,R.drawable.image5),
            Quote(R.string.affirmation6,R.drawable.image6),
            Quote(R.string.affirmation7,R.drawable.image7),
            Quote(R.string.affirmation8,R.drawable.image8),
            Quote(R.string.affirmation9,R.drawable.image9),
            Quote(R.string.affirmation10,R.drawable.image10)
            )
    }
}