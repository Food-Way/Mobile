package com.example.foodway.repository

import com.example.foodway.model.Customer
import com.example.foodway.model.Establishment
import com.example.foodway.model.Favorite
import retrofit2.Response

interface ISearchUserRepository {
    suspend fun getUsersEstablishment(): Response<List<Establishment>>
    suspend fun getUsersCustomer(): Response<List<Customer>>
    suspend fun getFavorites(): Response<List<Favorite>>
}