package com.example.foodway.data.searchUser.remote

import com.example.foodway.domain.searchUser.model.SearchedCustomer
import com.example.foodway.domain.searchUser.model.SearchedEstablishment
import com.example.foodway.domain.searchUser.repository.ISearchUserRepository
import retrofit2.Response
import java.util.UUID

class SearchUserRepositoryImpl(
    private val api: SearchUserService
) : ISearchUserRepository {
    override suspend fun getAllEstablishments(
        idSession: UUID,
        searchFilter: String
    ): Response<List<SearchedEstablishment>> {
        return api.getAllEstablishments(idSession, searchFilter)
    }

//    override suspend fun getAllFavorites(
//        idSession: UUID,
//        idUser: UUID,
//        token: String
//    ): Response<List<SearchedEstablishment>> {
//        return api.getAllFavorites(idSession, idUser, token)
//    }

    override suspend fun getAllCustomers(
        idSession: UUID,
        token: String
    ): Response<List<SearchedCustomer>> {
        return api.getAllCustomers(
            idSession,
            token
        )
    }

    override suspend fun patchFavorite(
        idCustomer: UUID,
        idEstablishment: UUID,
        token: String
    ): Response<Unit> {
        return api.patchFavorite(
            idCustomer, idEstablishment, token
        )
    }
}