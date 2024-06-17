package com.example.foodway.domain.establishmentMenu.usecase

import android.util.Log
import com.example.foodway.domain.establishmentMenu.model.Product
import com.example.foodway.domain.repository.IProductRepository
import java.util.UUID

class GetEstablishmentMenuUseCase(
    private val repository: IProductRepository
) {
    suspend operator fun invoke(
        idEstablishment: UUID,
        orderBy: String
    ): List<Product> {
        try {

            Log.d("TAG", "GetEstablishmentMenuUseCase: $idEstablishment")
            Log.d("TAG", "GetEstablishmentMenuUseCase: $orderBy")

            val response = repository.getAllProducts(
                idEstablishment = idEstablishment,
                orderBy = orderBy
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