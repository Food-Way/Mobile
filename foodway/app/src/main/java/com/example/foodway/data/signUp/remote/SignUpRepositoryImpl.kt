package com.example.foodway.data.signUp.remote

import com.example.foodway.domain.signUp.model.SignUpCustomer
import com.example.foodway.domain.signUp.model.SignUpEstablishment
import com.example.foodway.domain.signUp.repository.ISignUpRepository
import retrofit2.Response

class SignUpRepositoryImpl (
    private val api: SignUpService
) : ISignUpRepository {
    override suspend fun create(signUpCustomer: SignUpCustomer): Response<Unit> {
        return api.signUpCustomer(signUpCustomer)
    }

    override suspend fun create(signUpEstablishment: SignUpEstablishment): Response<Unit> {
       return api.signUpEstablishment(signUpEstablishment)
    }
}