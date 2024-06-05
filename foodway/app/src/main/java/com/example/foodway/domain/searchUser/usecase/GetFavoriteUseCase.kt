package com.example.foodway.domain.searchUser.usecase

import com.example.foodway.domain.model.Establishment
import com.example.foodway.domain.searchUser.repository.ISearchUserRepository
import java.util.UUID

class GetFavoriteUseCase(
    private val repository: ISearchUserRepository
) {
    suspend operator fun invoke(idSession: UUID, idUser: UUID): List<Establishment> {
        try {
            val response = repository.getAllFavorites(idSession = idSession, idUser = idUser)
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