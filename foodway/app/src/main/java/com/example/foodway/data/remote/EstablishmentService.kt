package com.example.foodway.data.remote

import com.example.foodway.domain.edit.establishment.model.EditEstablishmentAccount
import com.example.foodway.domain.edit.establishment.model.EditEstablishmentProfile
import com.example.foodway.domain.edit.establishment.model.GetProfileEstablishmentEdit
import com.example.foodway.domain.model.Establishment
import com.example.foodway.domain.profile.establishment.model.ProfileEstablishment
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.Path
import java.util.UUID

interface EstablishmentService {
    @GET("establishments/profile/{idEstablishment}")
    suspend fun getEstablishmentProfile(
        @Path("idEstablishment") idEstablishment: UUID
    ): Response<ProfileEstablishment>

    @GET("establishments/search")
    suspend fun searchEstablishments(): Response<List<Establishment>>

    @PATCH("establishments/mobile/profile/{id}")
    suspend fun updateCustomerProfileInfo(
        @Path("id") idEstablishment: UUID,
        @Body editEstablishmentProfile: EditEstablishmentProfile,
        @Header("Authorization") token: String
    ): Response<Unit>

    @PATCH("establishments/mobile/account/{id}")
    suspend fun updateCustomerPersonalInfo(
        @Path("id") idEstablishment: UUID,
        @Body editEstablishmentAccount: EditEstablishmentAccount
    ): Response<Unit>

    @GET("establishments/{id}")
    suspend fun getEstablishment(
        @Path("id") idEstablishment: UUID
    ): Response<GetProfileEstablishmentEdit>

}