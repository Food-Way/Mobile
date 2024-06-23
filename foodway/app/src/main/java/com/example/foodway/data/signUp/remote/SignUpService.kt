package com.example.foodway.data.signUp.remote

import com.example.foodway.domain.signUp.model.SignUpCustomer
import com.example.foodway.domain.signUp.model.SignUpEstablishment
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {
    @POST("customers")
    suspend fun signUpCustomer(@Body signUpCustomer: SignUpCustomer): Response<Unit>

    @POST("establishments")
    suspend fun signUpEstablishment(@Body signUpEstablishment: SignUpEstablishment): Response<Unit>

}