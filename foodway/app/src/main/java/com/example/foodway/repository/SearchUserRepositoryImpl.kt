package com.example.foodway.repository

import com.example.foodway.api.ApiConfig
import com.example.foodway.model.Customer
import com.example.foodway.model.Establishment
import com.example.foodway.model.Favorite
import com.example.foodway.service.SearchUserService
import retrofit2.Response

class SearchUserRepositoryImpl : ISearchUserRepository {
    private val api by lazy {
        ApiConfig
            .getInstance()
            .create(SearchUserService::class.java)
    }

    override suspend fun getUsersEstablishment(): Response<List<Establishment>> {
        return api.searchAllEstablishments()
    }

    override suspend fun getUsersCustomer(): Response<List<Customer>> {
        return api.searchAllCustomers()
    }

    override suspend fun getFavorites(): Response<List<Favorite>> {
        return api.favoritesUser()
    }
}