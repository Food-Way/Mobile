package com.example.foodway.domain.searchUser.usecase

import com.example.foodway.domain.searchUser.model.SearchedCustomer
import com.example.foodway.domain.searchUser.repository.ISearchUserRepository
import java.util.UUID

class GetCustomerUseCase(
    private val repository: ISearchUserRepository
) {
    suspend operator fun invoke(
        idSession: UUID,
        token: String
    ): List<SearchedCustomer> {
        try {
            val response = repository.getAllCustomers(
                idSession = idSession,
                token = token
            )
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