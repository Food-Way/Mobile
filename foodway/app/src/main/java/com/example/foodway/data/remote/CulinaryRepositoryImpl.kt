package com.example.foodway.data.remote

import com.example.foodway.data.network.ApiConfig
import com.example.foodway.domain.repository.ICulinaryRepository
import com.example.foodway.model.Culinary
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