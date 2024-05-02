package com.example.foodway.service

import com.example.foodway.model.Culinary
import retrofit2.Response
import retrofit2.http.GET

interface CulinaryService {
    @GET("culinaries")
    suspend fun getAllCulinaries(): Response<List<Culinary>>
}