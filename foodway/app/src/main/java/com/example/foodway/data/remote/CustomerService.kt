package com.example.foodway.data.remote

import com.example.foodway.domain.edit.customer.model.EditCustomerAccount
import com.example.foodway.domain.edit.customer.model.EditCustomerProfile
import com.example.foodway.domain.model.Customer
import com.example.foodway.domain.profile.customer.model.ProfileCustomer
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import java.util.UUID

interface CustomerService {
    @GET("customers/search")
    suspend fun searchAllCustomers(): List<Customer>

    @GET("customers/{idCustomer}")
    suspend fun getCustomer(
        @Path("idCustomer") idCustomer: UUID
    ): Response<ProfileCustomer>

    @GET("customers/profile/{idCustomer}")
    suspend fun getCustomerProfile(
        @Path("idCustomer") idCustomer: UUID
    ): Response<ProfileCustomer>

    @PATCH("customers/{idCustomer}/establishments/{idEstablishment}/favorite")
    suspend fun favoriteEstablishment(
        @Path("idCustomer") idCustomer: UUID,
        @Path("idEstablishment") idEstablishment: UUID
    ): Response<Unit>

    @PATCH("customers/profile/{idCustomer}")
    suspend fun updateCustomerProfileInfo(
        @Path("idCustomer") idCustomer: UUID,
        @Body editCustomerProfile: EditCustomerProfile
    ): Response<Unit>

    @PATCH("customers/personal/{idCustomer}")
    suspend fun updateCustomerPersonalInfo(
        @Path("idCustomer") idCustomer: UUID,
        @Body editCustomerAccount: EditCustomerAccount
    ): Response<Unit>

}