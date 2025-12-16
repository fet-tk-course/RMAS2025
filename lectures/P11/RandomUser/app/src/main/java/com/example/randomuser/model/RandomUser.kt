package com.example.randomuser.model

import com.google.gson.annotations.SerializedName

data class RandomUser(
    val id: String,
    @SerializedName("full_name")
    val name: String,
    val age: Int,
    val country: String,
    val avatar: String
)
