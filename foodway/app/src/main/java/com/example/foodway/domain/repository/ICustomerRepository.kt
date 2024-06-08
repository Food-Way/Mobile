package com.example.foodway.domain.repository


import com.example.foodway.domain.edit.customer.model.EditCustomerAccount
import com.example.foodway.domain.edit.customer.model.EditCustomerProfile
import com.example.foodway.domain.profile.customer.model.ProfileCustomer
import retrofit2.Response
import java.util.UUID

interface ICustomerRepository {
    suspend fun getCustomerProfile(idCustomer: UUID): Response<ProfileCustomer>
    suspend fun getCustomerAccount(idCustomer: UUID): Response<ProfileCustomer>
    suspend fun updateAccount(idCustomer: UUID, editCustomerAccount: EditCustomerAccount, token: String): Response<Unit>
    suspend fun updateAccount(idCustomer: UUID, editCustomerProfile: EditCustomerProfile): Response<Unit>
}