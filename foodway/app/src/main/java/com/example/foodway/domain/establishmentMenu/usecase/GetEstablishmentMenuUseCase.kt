package com.example.foodway.domain.establishmentMenu.usecase

import com.example.foodway.domain.establishmentMenu.model.Product
import com.example.foodway.domain.repository.IProductRepository
import java.util.UUID

class GetEstablishmentMenuUseCase(
    private val repository: IProductRepository
) {
    suspend operator fun invoke(idEstablishment: UUID): List<Product> {
        try {
            val response = repository.getAllProducts(idEstablishment = idEstablishment)
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