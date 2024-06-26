package com.example.foodway.data.establishmentMenu.remote

import com.example.foodway.domain.establishmentMenu.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.UUID

interface ProductService {
    @GET("products/establishments/{idEstablishment}/{orderBy}")
    suspend fun getAllProducts(
        @Path("idEstablishment") idEstablishment: UUID,
        @Path("orderBy") orderBy: String
    ): Response<List<Product>>
}