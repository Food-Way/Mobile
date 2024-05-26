package com.example.foodway.data.searchUser.remote

import com.example.foodway.domain.model.Customer
import com.example.foodway.domain.model.Establishment
import com.example.foodway.domain.model.Favorite
import com.example.foodway.domain.searchUser.repository.ISearchUserRepository
import retrofit2.Response
import java.util.UUID

class SearchUserRepositoryImpl(
    private val api: SearchUserService
) : ISearchUserRepository {

    override suspend fun getAllEstablishments(idSession: UUID): Response<List<Establishment>> {
        return api.getAllEstablishments(idSession)
    }

    override suspend fun getAllCustomers(idSession: UUID): Response<List<Customer>> {
        return api.getAllCustomers(idSession)
    }

    override suspend fun getAllFavorites(idSession: UUID): Response<List<Favorite>> {
        return api.getAllFavorites(idSession)
    }
}