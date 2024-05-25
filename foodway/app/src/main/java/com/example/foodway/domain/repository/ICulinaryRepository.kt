package com.example.foodway.domain.repository

import com.example.foodway.model.Culinary
import retrofit2.Response

interface ICulinaryRepository {
    suspend fun getAllCulinaries(): Response<List<Culinary>>
}