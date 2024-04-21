package com.example.foodway.service

import com.example.foodway.model.Customer
import com.example.foodway.model.ProfileCustomer
import com.example.foodway.model.SignUpCustomer
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.UUID

interface CustomerService {
    @GET("/customers/search")
    suspend fun searchAllCustomers(): List<Customer>

    @GET("/customers/profile/{idCustomer}")
    suspend fun getCustomerProfile(@Path("idCustomer") idCustomer: UUID): Response<ProfileCustomer>

    @POST("/customers")
    suspend fun signUpCustomer(@Body signUpCustomer: SignUpCustomer): Response<Unit>

    @PATCH("/customers/{idCustomer}/establishments/{idEstablishment}/favorite")
    suspend fun favoriteEstablishment(@Path("idCustomer") idCustomer: UUID, @Path("idEstablishment") idEstablishment: UUID): Response<Unit>

    @PATCH("/customers/profile/{id}")
    suspend fun updateCustomerProfileInfo(@Path("idCustomer") idCustomer: UUID): Response<Unit>

    @PATCH("/customers/personal/{id}")
    suspend fun updateCustomerPersonalInfo(@Path("idCustomer") idCustomer: UUID): Response<Unit>

}