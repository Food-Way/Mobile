package com.example.foodway.domain.profile.customer.usecase

import com.example.foodway.domain.profile.customer.model.ProfileCustomer
import com.example.foodway.domain.repository.ICustomerRepository
import java.util.UUID

class GetCustomerProfileUseCase(
    private val repository: ICustomerRepository
) {
    suspend operator fun invoke(idCustomer: UUID): ProfileCustomer {
        try {
            val response = repository.getCustomerProfile(idCustomer = idCustomer)
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