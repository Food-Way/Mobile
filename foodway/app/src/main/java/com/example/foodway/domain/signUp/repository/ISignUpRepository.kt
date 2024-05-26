package com.example.foodway.domain.signUp.repository

import com.example.foodway.domain.signUp.model.SignUpCustomer
import com.example.foodway.domain.signUp.model.SignUpEstablishment
import retrofit2.Response

interface ISignUpRepository {
    suspend fun create(signUpCustomer: SignUpCustomer): Response<Unit>
    suspend fun create(signUpEstablishment: SignUpEstablishment): Response<Unit>
}