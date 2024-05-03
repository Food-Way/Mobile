package com.example.foodway.service

import com.example.foodway.model.Establishment
import com.example.foodway.model.ProfileEstablishment
import com.example.foodway.model.SignUpEstablishment
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.UUID

interface EstablishmentService {
    @GET("establishments/profile/{idEstablishment}")
    suspend fun getEstablishmentProfile(@Path("idEstablishment") idEstablishment: UUID): Response<ProfileEstablishment>

    @GET("establishments/search")
    suspend fun searchEstablishments(): Response<List<Establishment>>

    @POST("establishments")
    suspend fun signUpEstablishment(@Body signUpEstablishment: SignUpEstablishment): Response<Unit>

    @PATCH("establishments/profile/{idEstablishment}")
    suspend fun updateCustomerProfileInfo(@Path("idEstablishment") idEstablishment: UUID): Response<Unit>

    @PATCH("establishments/personal/{idEstablishment}")
    suspend fun updateCustomerPersonalInfo(@Path("idEstablishment") idEstablishment: UUID): Response<Unit>
}