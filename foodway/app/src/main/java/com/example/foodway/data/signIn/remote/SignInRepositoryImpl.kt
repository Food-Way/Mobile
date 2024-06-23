package com.example.foodway.data.signIn.remote

import com.example.foodway.domain.signIn.model.AuthResponse
import com.example.foodway.domain.signIn.model.SignIn
import com.example.foodway.domain.signIn.repository.ISignInRepository
import retrofit2.Response

class SignInRepositoryImpl (
    private val api: SignInService
) : ISignInRepository{
    override suspend fun create(signIn: SignIn): Response<AuthResponse>{
        return api.login(signIn)
    }
}