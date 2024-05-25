package com.example.foodway.domain.signIn.repository

import com.example.foodway.model.Customer
import com.example.foodway.domain.signIn.model.SignIn
import retrofit2.Response

interface ISignInRepository{
    suspend fun login(signIn: SignIn): Response<Customer>
}