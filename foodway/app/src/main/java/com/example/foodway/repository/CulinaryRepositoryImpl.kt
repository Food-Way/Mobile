package com.example.foodway.repository

import com.example.foodway.api.ApiConfig
import com.example.foodway.model.Culinary
import com.example.foodway.service.CulinaryService
import retrofit2.Response

class CulinaryRepositoryImpl : ICulinaryRepository {

    private val api by lazy {
        ApiConfig
            .getInstance()
            .create(CulinaryService::class.java)
    }

    override suspend fun getAllCulinaries(): Response<List<Culinary>> {
        return api.getAllCulinaries()
    }
}