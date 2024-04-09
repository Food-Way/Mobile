package com.example.foodway.api

import com.example.foodway.model.Culinary
import retrofit2.http.GET

interface ApiService {
    @GET("culinaries")
    suspend fun getCulinaries(): List<Culinary>
}