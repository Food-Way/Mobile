package com.example.foodway.data.signIn.remote

import com.example.foodway.data.network.ApiConfig
import com.example.foodway.model.Customer
import com.example.foodway.domain.signIn.model.SignIn
import com.example.foodway.domain.signIn.repository.ISignInRepository
import retrofit2.Response

class SignInRepositoryImpl : ISignInRepository {
    private val api by lazy {
        ApiConfig
            .getInstance()
            .create(SignInService::class.java)
    }

    override suspend fun login(signIn: SignIn): Response<Customer>{
        return api.login(signIn)
    }
}