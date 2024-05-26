package com.example.foodway.domain.searchUser.repository

import com.example.foodway.domain.model.Customer
import com.example.foodway.domain.model.Establishment
import com.example.foodway.domain.model.Favorite
import retrofit2.Response
import java.util.UUID

interface ISearchUserRepository {
    suspend fun getAllEstablishments(idSession: UUID): Response<List<Establishment>>
    suspend fun getAllCustomers(idSession: UUID): Response<List<Customer>>
    suspend fun getAllFavorites(idSession: UUID): Response<List<Favorite>>
}