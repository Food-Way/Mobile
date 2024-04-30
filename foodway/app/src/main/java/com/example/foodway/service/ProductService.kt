package com.example.foodway.service

import com.example.foodway.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.UUID

interface ProductService {
    @GET("products/establishmentsAll/{idEstablishment}")
    suspend fun getAllProducts(@Path("idEstablishment") idEstablishment: UUID): Response<List<Product>>
}