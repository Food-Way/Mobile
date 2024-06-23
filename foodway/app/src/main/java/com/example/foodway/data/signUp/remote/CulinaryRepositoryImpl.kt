package com.example.foodway.data.signUp.remote

import com.example.foodway.domain.model.Culinary
import com.example.foodway.domain.repository.ICulinaryRepository
import retrofit2.Response

class CulinaryRepositoryImpl(
    private val api : CulinaryService
) : ICulinaryRepository {
    override suspend fun getAllCulinaries(): Response<List<Culinary>> {
        return api.getAllCulinaries()
    }
}