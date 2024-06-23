package com.example.foodway.data.signUp.remote

import com.example.foodway.domain.model.Culinary
import retrofit2.Response
import retrofit2.http.GET

interface CulinaryService {
    @GET("culinaries")
    suspend fun getAllCulinaries(): Response<List<Culinary>>
}