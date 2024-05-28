package com.example.foodway.domain.edit.customer.usecase

import com.example.foodway.domain.edit.customer.model.EditCustomerProfile
import com.example.foodway.domain.edit.establishment.model.EditEstablishmentProfile
import com.example.foodway.domain.repository.ICustomerRepository
import com.example.foodway.domain.repository.IEstablishmentRepository
import com.example.foodway.utils.validateField
import java.util.UUID

class UpdateProfileUseCase(
    private val customerRepository: ICustomerRepository,
    private val establishmentRepository: IEstablishmentRepository
) {
    suspend operator fun invoke(
        idCustomer: UUID,
        editCustomerProfile: EditCustomerProfile
    ) {
        try {
            with(editCustomerProfile) {
                validateField(name, "Name")
                validateField(bio, "Bio")
                validateField(photo, "Photo")
            }
            val response = customerRepository.updateAccount(
                idCustomer = idCustomer,
                editCustomerProfile = editCustomerProfile
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

    suspend operator fun invoke(
        idEstablishment: UUID,
        editEstablishmentProfile: EditEstablishmentProfile
    ) {
        try {
            with(editEstablishmentProfile) {
                validateField(name, "Name")
                validateField(description, "Description")
                validateField(photo, "Photo")
            }
            val response = establishmentRepository.updateProfile(
                idEstablishment = idEstablishment,
                editEstablishmentProfile = editEstablishmentProfile
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