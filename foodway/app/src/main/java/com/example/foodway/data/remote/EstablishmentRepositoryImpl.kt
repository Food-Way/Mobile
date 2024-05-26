package com.example.foodway.data.remote

import com.example.foodway.domain.profile.establishment.model.ProfileEstablishment
import com.example.foodway.domain.repository.IEstablishmentRepository
import retrofit2.Response
import java.util.UUID

class EstablishmentRepositoryImpl (
    private val api : EstablishmentService
) : IEstablishmentRepository {
    override suspend fun getEstablishmentProfile(idEstablishment: UUID): Response<ProfileEstablishment> {
        return api.getEstablishmentProfile(idEstablishment)
    }
}