package com.example.foodway.repository

import com.example.foodway.api.ApiConfig
import com.example.foodway.model.ProfileCustomer
import com.example.foodway.model.SignUpCustomer
import com.example.foodway.service.CustomerService
import retrofit2.Response
import java.util.UUID

class CustomerRepositoryImpl : ICustomerRepository {
    private val api by lazy {
        ApiConfig
            .getInstance()
            .create(CustomerService::class.java)
    }

    override suspend fun getCustomerProfile(idUser: UUID): Response<ProfileCustomer> {
        return api.getCustomerProfile(idUser)
    }

    override suspend fun postCustomer(signUpCustomer: SignUpCustomer): Response<Unit> {
        return api.signUpCustomer(signUpCustomer)
    }
}