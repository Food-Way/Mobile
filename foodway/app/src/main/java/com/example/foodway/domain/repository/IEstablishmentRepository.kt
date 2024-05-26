package com.example.foodway.domain.repository

import com.example.foodway.domain.profile.establishment.model.ProfileEstablishment
import retrofit2.Response
import java.util.UUID

interface IEstablishmentRepository {
    suspend fun getEstablishmentProfile(idEstablishment: UUID): Response<ProfileEstablishment>
}