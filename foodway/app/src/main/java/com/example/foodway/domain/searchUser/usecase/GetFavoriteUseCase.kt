package com.example.foodway.domain.searchUser.usecase

import com.example.foodway.domain.model.Favorite
import com.example.foodway.domain.searchUser.repository.ISearchUserRepository
import java.util.UUID

class GetFavoriteUseCase(
    private val repository: ISearchUserRepository
) {
    suspend operator fun invoke(idSession: UUID): List<Favorite> {
        try {
            val response = repository.getAllFavorites(idSession = idSession)
            if (response.isSuccessful) {
                return response.body() ?: emptyList()
            } else {
                throw Exception(response.errorBody().toString())
            }
        } catch (e: Exception) {
            throw e
        }
    }
}