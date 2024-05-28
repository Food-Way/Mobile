package com.example.foodway.data.remote

import com.example.foodway.domain.edit.customer.model.EditCustomerAccount
import com.example.foodway.domain.edit.customer.model.EditCustomerProfile
import com.example.foodway.domain.profile.customer.model.ProfileCustomer
import com.example.foodway.domain.repository.ICustomerRepository
import retrofit2.Response
import java.util.UUID

class CustomerRepositoryImpl(
    private val api: CustomerService
) : ICustomerRepository {
    override suspend fun getCustomerProfile(
        idCustomer: UUID
    ): Response<ProfileCustomer> {
        return api.getCustomerProfile(
            idCustomer = idCustomer
        )
    }

    override suspend fun updateAccount(
        idCustomer: UUID,
        editCustomerAccount: EditCustomerAccount
    ): Response<Unit> {
        return api.updateCustomerPersonalInfo(
            idCustomer = idCustomer,
            editCustomerAccount = editCustomerAccount
        )
    }

    override suspend fun updateAccount(
        idCustomer: UUID,
        editCustomerProfile: EditCustomerProfile
    ): Response<Unit> {
        return api.updateCustomerProfileInfo(
            idCustomer = idCustomer,
            editCustomerProfile = editCustomerProfile
        )
    }
}