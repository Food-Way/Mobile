package com.example.foodway.domain.searchUser.usecase

import com.example.foodway.domain.model.Establishment
import com.example.foodway.domain.searchUser.repository.ISearchUserRepository
import java.util.UUID

class GetEstablishmentUseCase (
    private val repository: ISearchUserRepository
) {
    suspend operator fun invoke(idSession: UUID): List<Establishment> {
        try {
            val response = repository.getAllEstablishments(idSession = idSession)
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