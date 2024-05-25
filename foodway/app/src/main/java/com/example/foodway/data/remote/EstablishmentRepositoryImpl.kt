package com.example.foodway.data.remote

import com.example.foodway.data.network.ApiConfig
import com.example.foodway.domain.profile.establishment.model.ProfileEstablishment
import com.example.foodway.domain.repository.IEstablishmentRepository
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