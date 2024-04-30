package com.example.foodway.repository

import com.example.foodway.api.ApiConfig
import com.example.foodway.model.Product
import com.example.foodway.service.ProductService
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