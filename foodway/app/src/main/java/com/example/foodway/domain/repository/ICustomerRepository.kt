package com.example.foodway.domain.repository

import com.example.foodway.domain.profile.customer.model.ProfileCustomer
import com.example.foodway.domain.signUp.customer.model.SignUpCustomer
import retrofit2.Response
import java.util.UUID

interface ICustomerRepository {
    suspend fun getCustomerProfile(idUser: UUID): Response<ProfileCustomer>
    suspend fun postCustomer(signUpCustomer: SignUpCustomer): Response<Unit>
}