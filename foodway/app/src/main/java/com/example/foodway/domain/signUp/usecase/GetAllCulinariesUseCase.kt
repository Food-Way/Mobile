package com.example.foodway.domain.signUp.usecase

import com.example.foodway.domain.model.Culinary
import com.example.foodway.domain.repository.ICulinaryRepository

class GetAllCulinariesUseCase(
    private val repository: ICulinaryRepository
) {
    suspend operator fun invoke() : List<Culinary> {
        try {
            val response = repository.getAllCulinaries()
            if(response.isSuccessful) {
                return response.body() ?: emptyList()
            } else {
                throw Exception(response.errorBody().toString())
            }
        } catch (e: Exception) {
            throw e
        }
    }
}