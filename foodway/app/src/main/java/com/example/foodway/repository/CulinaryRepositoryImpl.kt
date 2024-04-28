package com.example.foodway.repository

import com.example.foodway.api.ApiConfig
import com.example.foodway.model.Culinary
import com.example.foodway.service.CulinariesService
import retrofit2.Response

class CulinaryRepositoryImpl : ICulinaryRepository {

    private val api by lazy {
        ApiConfig.getInstance().create(CulinariesService::class.java)
    }

    override suspend fun getAllCulinaries(): Response<List<Culinary>> {
        return api.getAllCulinaries()
    }
}