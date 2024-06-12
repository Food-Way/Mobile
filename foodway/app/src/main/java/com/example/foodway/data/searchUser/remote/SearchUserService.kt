package com.example.foodway.data.searchUser.remote

import com.example.foodway.domain.searchUser.model.SearchedCustomer
import com.example.foodway.domain.searchUser.model.SearchedEstablishment
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.UUID

interface SearchUserService {
    @GET("customers/search")
    suspend fun getAllCustomers(
        @Header("ID_SESSION") idSession: UUID,
        @Header("token") token: String,
        @Query("customerName") searchFilter: String = ""
    ): Response<List<SearchedCustomer>>

    @GET("establishments/search")
    suspend fun getAllEstablishments(
        @Header("ID_SESSION") idSession: UUID,
        @Query("searchFilter") searchFilter: String
    ): Response<List<SearchedEstablishment>>

//    @GET("favorites/{idUser}")
//    suspend fun getAllFavorites(
//        @Header("ID_SESSION") idSession: UUID,
//        @Path("idUser") idUser: UUID,
//        @Header("token") token: String
//    ): Response<List<SearchedEstablishment>>

    @PATCH("customers/{idCustomer}/establishments/{idEstablishment}/favorite")
    suspend fun patchFavorite(
        @Path("idCustomer") idCustomer: UUID,
        @Path("idEstablishment") idEstablishment: UUID,
        @Header("token") token: String
    ): Response<Unit>

}