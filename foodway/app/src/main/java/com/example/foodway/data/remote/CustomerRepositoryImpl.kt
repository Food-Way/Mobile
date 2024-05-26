package com.example.foodway.data.remote

import com.example.foodway.domain.profile.customer.model.ProfileCustomer
import com.example.foodway.domain.repository.ICustomerRepository
import retrofit2.Response
import java.util.UUID

class CustomerRepositoryImpl(
    private val api: CustomerService
) : ICustomerRepository {
    override suspend fun getCustomerProfile(idCustomer: UUID): Response<ProfileCustomer> {
        return api.getCustomerProfile(idCustomer)
    }
}