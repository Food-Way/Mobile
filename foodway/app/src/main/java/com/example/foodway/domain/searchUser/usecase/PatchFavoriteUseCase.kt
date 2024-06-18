package com.example.foodway.domain.searchUser.usecase

import com.example.foodway.domain.searchUser.repository.ISearchUserRepository
import java.util.UUID

class PatchFavoriteUseCase(
    private val repository: ISearchUserRepository
) {
    suspend operator fun invoke(
        idCustomer: UUID,
        idEstablishment: UUID,
        token: String
    ) {
        try {
            val response = repository.patchFavorite(
                idCustomer = idCustomer,
                idEstablishment = idEstablishment,
                token = token
            )
            if (response.isSuccessful) {
                return response.body() ?: throw Exception("Empty response")
            } else {
                throw Exception(response.errorBody().toString())
            }
        } catch (e: Exception) {
            throw e
        }
    }
}