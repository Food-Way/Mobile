package com.example.foodway.domain.profile.establishment.usecase

import com.example.foodway.domain.profile.establishment.model.PostRate
import com.example.foodway.domain.profile.establishment.repository.ICommentRepository

class PostRateUseCase(
    private val repository: ICommentRepository
) {
    suspend operator fun invoke(
        token: String,
        rates: PostRate
    ) {
        try {
            val response = repository.createRate(
                token = token,
                rates = rates
            )
            if (response.isSuccessful) {
                return response.body() ?: throw Exception("Response body is null")
            } else {
                throw Exception(response.errorBody().toString())
            }
        } catch (e: Exception) {
            throw e
        }
    }
}