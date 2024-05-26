package com.example.foodway.domain.signIn.repository

import com.example.foodway.domain.signIn.model.AuthResponse
import com.example.foodway.domain.signIn.model.SignIn
import retrofit2.Response

interface ISignInRepository{
    suspend fun create(signIn: SignIn): Response<AuthResponse>
}