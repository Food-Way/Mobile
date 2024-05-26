package com.example.foodway.domain.repository


import com.example.foodway.domain.profile.customer.model.ProfileCustomer
import retrofit2.Response
import java.util.UUID

interface ICustomerRepository {
    suspend fun getCustomerProfile(idCustomer: UUID): Response<ProfileCustomer>
}