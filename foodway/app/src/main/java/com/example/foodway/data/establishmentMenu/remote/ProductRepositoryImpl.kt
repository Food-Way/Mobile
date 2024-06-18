package com.example.foodway.data.establishmentMenu.remote

import com.example.foodway.domain.establishmentMenu.model.Product
import com.example.foodway.domain.repository.IProductRepository
import retrofit2.Response
import java.util.UUID

class ProductRepositoryImpl(
    private val api: ProductService
) : IProductRepository {

    override suspend fun getAllProducts(
        idEstablishment: UUID,
        orderBy: String
    ): Response<List<Product>> {
        return api.getAllProducts(
            idEstablishment,
            orderBy
        )
    }
}