package com.example.foodway.repository

import com.example.foodway.api.ApiConfig
import com.example.foodway.model.ProfileEstablishment
import com.example.foodway.service.EstablishmentService
import retrofit2.Response
import java.util.UUID

class EstablishmentRepositoryImpl : IEstablishmentRepository {
    private val api by lazy {
        ApiConfig
            .getInstance()
            .create(EstablishmentService::class.java)
    }

    override suspend fun getEstablishmentProfile(idUser: UUID): Response<ProfileEstablishment> {
        return api.getEstablishmentProfile(idUser)
    }
}