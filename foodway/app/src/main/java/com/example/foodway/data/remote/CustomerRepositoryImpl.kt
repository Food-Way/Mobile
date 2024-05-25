package com.example.foodway.data.remote

import com.example.foodway.data.network.ApiConfig
import com.example.foodway.domain.profile.customer.model.ProfileCustomer
import com.example.foodway.domain.repository.ICustomerRepository
import com.example.foodway.domain.signUp.customer.model.SignUpCustomer
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