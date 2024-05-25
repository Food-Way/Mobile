package com.example.foodway.data.signIn.remote

import com.example.foodway.model.Customer
import com.example.foodway.domain.signIn.model.SignIn
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInService {
    @POST("users/login")
    suspend fun login(@Body signIn: SignIn): Response<Customer>
}