package com.example.randomuser.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://api.api-ninjas.com"
    // 1) Logging interceptor
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    // 2) OkHttpClient
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
    // 3) Retrofit instance
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    // 4) API (interface implementation)
    val api: RandomUserApi = retrofit.create(RandomUserApi::class.java)
}

