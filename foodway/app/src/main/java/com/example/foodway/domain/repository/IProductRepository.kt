package com.example.foodway.domain.repository

import com.example.foodway.domain.establishmentMenu.model.Product
import retrofit2.Response
import java.util.UUID

interface IProductRepository {
    suspend fun getAllProducts(idEstablishment: UUID): Response<List<Product>>
}