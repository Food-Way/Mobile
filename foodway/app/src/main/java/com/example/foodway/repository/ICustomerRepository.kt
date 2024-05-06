package com.example.foodway.repository

import com.example.foodway.model.ProfileCustomer
import com.example.foodway.model.SignUpCustomer
import retrofit2.Response
import java.util.UUID

interface ICustomerRepository {
    suspend fun getCustomerProfile(idUser: UUID): Response<ProfileCustomer>
    suspend fun postCustomer(signUpCustomer: SignUpCustomer): Response<Unit>
}