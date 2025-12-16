package com.example.randomuser.network

import com.example.randomuser.model.RandomUser
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RandomUserApi{

    @GET("/v2/randomuser")
    suspend fun getRandomUsers(
        @Header("X-Api-Key") apiKey: String,
        @Query("count") count: Int
    ) : List<RandomUser>
}

