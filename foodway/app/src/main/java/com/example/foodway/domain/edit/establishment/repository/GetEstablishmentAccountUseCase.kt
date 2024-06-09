package com.example.foodway.domain.edit.establishment.repository

import com.example.foodway.domain.edit.establishment.model.GetProfileEstablishmentEdit
import com.example.foodway.domain.repository.IEstablishmentRepository
import java.util.UUID

class GetEstablishmentAccountUseCase(
    private val establishmentRepository: IEstablishmentRepository
) {
    suspend operator fun invoke(idEstablishment: UUID) : GetProfileEstablishmentEdit {
        try {
            val response = establishmentRepository.getEstablishment(
                idEstablishment = idEstablishment
            )
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