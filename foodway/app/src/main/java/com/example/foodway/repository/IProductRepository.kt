package com.example.foodway.repository

import com.example.foodway.model.Product
import retrofit2.Response
import java.util.UUID

interface IProductRepository {
    suspend fun getAllProducts(idEstablishment: UUID): Response<List<Product>>
}