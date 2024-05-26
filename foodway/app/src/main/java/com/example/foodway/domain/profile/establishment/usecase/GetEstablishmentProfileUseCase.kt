package com.example.foodway.domain.profile.establishment.usecase

import com.example.foodway.domain.profile.establishment.model.ProfileEstablishment
import com.example.foodway.domain.repository.IEstablishmentRepository
import java.util.UUID

class GetEstablishmentProfileUseCase(
    private val repository: IEstablishmentRepository
) {
    suspend operator fun invoke(idEstablishment: UUID): ProfileEstablishment {
        try {
            val response = repository.getEstablishmentProfile(idEstablishment = idEstablishment)
            if (response.isSuccessful) {
                return response.body() ?: throw Exception("Response body is null")
            } else {
                throw Exception(response.errorBody().toString())
            }
        } catch (e: Exception) {
            throw e
        }
    }
}