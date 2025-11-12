package com.example.positivequotessolution.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Quote(
    @StringRes val stringResourceID: Int,
    @DrawableRes val imageResourceID: Int
)
