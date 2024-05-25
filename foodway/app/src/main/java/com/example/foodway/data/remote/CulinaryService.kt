package com.example.foodway.data.remote

import com.example.foodway.model.Culinary
import retrofit2.Response
import retrofit2.http.GET

interface CulinaryService {
    @GET("culinaries")
    suspend fun getAllCulinaries(): Response<List<Culinary>>
}