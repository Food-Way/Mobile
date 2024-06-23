package com.example.foodway.domain.searchUser.repository

import com.example.foodway.domain.searchUser.model.SearchedCustomer
import com.example.foodway.domain.searchUser.model.SearchedEstablishment
import retrofit2.Response
import java.util.UUID

interface ISearchUserRepository {
    suspend fun getAllEstablishments(
        idSession: UUID,
        searchFilter: String
    ): Response<List<SearchedEstablishment>>

//    suspend fun getAllFavorites(
//        idSession: UUID,
//        idUser: UUID,
//        token: String
//    ): Response<List<SearchedEstablishment>>

    suspend fun getAllCustomers(
        idSession: UUID,
        token: String
    ): Response<List<SearchedCustomer>>

    suspend fun patchFavorite(
        idCustomer: UUID,
        idEstablishment: UUID,
        token: String
    ): Response<Unit>
}