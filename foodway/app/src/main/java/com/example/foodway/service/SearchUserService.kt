package com.example.foodway.service

import com.example.foodway.model.Customer
import com.example.foodway.model.Establishment
import com.example.foodway.model.Favorite
import retrofit2.Response
import retrofit2.http.GET

interface SearchUserService {
    @GET("customers")
    suspend fun searchAllCustomers(): Response<List<Customer>>

    @GET("establishments")
    suspend fun searchAllEstablishments(): Response<List<Establishment>>

    @GET("favorites/{idUser}")
    suspend fun favoritesUser(): Response<List<Favorite>>
}