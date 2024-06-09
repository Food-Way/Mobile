package com.example.foodway.domain.edit.usecase

import com.example.foodway.domain.edit.customer.model.EditCustomerAccount
import com.example.foodway.domain.edit.establishment.model.EditEstablishmentAccount
import com.example.foodway.domain.repository.ICustomerRepository
import com.example.foodway.domain.repository.IEstablishmentRepository
import com.example.foodway.utils.validateField
import java.util.UUID

class UpdateAccountUseCase(
    private val customerRepository: ICustomerRepository,
    private val establishmentRepository: IEstablishmentRepository
) {
    suspend operator fun invoke(
        idCustomer: UUID,
        editCustomerAccount: EditCustomerAccount,
        token: String
    ) {
        try {
            with(editCustomerAccount) {
                validateField(name, "Name")
                validateField(email, "Email")
                validateField(password, "Password")
            }
            val response = customerRepository.updateAccount(
                idCustomer = idCustomer,
                editCustomerAccount = editCustomerAccount,
                token = token
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
        editEstablishmentAccount: EditEstablishmentAccount,
        token: String
    ) {
        try {
            with(editEstablishmentAccount) {
//                validateField(fantasyName, "Fantasy name")
//                validateField(responsible, "Responsible")
//                validateField(cnpj, "CNPJ")
//                validateField(email, "Email")
//                validateField(password, "Password")
            }
            val response = establishmentRepository.updateAccount(
                idEstablishment = idEstablishment,
                editEstablishmentAccount = editEstablishmentAccount
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