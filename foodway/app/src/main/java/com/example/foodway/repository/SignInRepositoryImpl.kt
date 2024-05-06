package com.example.foodway.repository

import com.example.foodway.api.ApiConfig
import com.example.foodway.model.Customer
import com.example.foodway.model.Login
import com.example.foodway.service.LoginService
import retrofit2.Response

class SignInRepositoryImpl : ISignInRepository {
    private val api by lazy {
        ApiConfig
            .getInstance()
            .create(LoginService::class.java)
    }

    override suspend fun login(login: Login): Response<Customer>{
        return api.login(login)
    }
}