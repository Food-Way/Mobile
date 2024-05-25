package com.example.foodway.data.remote

import com.example.foodway.data.network.ApiConfig
import com.example.foodway.domain.establishmentMenu.model.Product
import com.example.foodway.domain.repository.IProductRepository
import retrofit2.Response
import java.util.UUID

class ProductRepositoryImpl : IProductRepository {

    private val api by lazy {
        ApiConfig
            .getInstance()
            .create(ProductService::class.java)
    }

    override suspend fun getAllProducts(idEstablishment: UUID): Response<List<Product>> {
        return api.getAllProducts(idEstablishment)
    }
}