package com.example.foodway.data.searchUser.remote

import com.example.foodway.domain.model.Customer
import com.example.foodway.domain.model.Establishment
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.UUID

interface SearchUserService {
    @GET("customers/search")
    suspend fun getAllCustomers(
        @Header("ID_SESSION") idSession: UUID
    ): Response<List<Customer>>

    @GET("establishments/search")
    suspend fun getAllEstablishments(
        @Header("ID_SESSION") idSession: UUID,
        @Query("searchFilter") searchFilter: String
    ): Response<List<Establishment>>

    @GET("favorites/{idUser}")
    suspend fun getAllFavorites(
        @Header("ID_SESSION") idSession: UUID,
        @Path("idUser") idUser: UUID
    ): Response<List<Establishment>>
}