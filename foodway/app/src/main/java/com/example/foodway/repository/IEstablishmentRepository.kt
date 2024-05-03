package com.example.foodway.repository

import com.example.foodway.model.ProfileEstablishment
import retrofit2.Response
import java.util.UUID

interface IEstablishmentRepository {
    suspend fun getEstablishmentProfile(idUser: UUID): Response<ProfileEstablishment>
}