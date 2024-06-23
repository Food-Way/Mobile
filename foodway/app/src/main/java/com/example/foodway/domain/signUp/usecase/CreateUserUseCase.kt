package com.example.foodway.domain.signUp.usecase

import com.example.foodway.domain.signUp.model.SignUpCustomer
import com.example.foodway.domain.signUp.model.SignUpEstablishment
import com.example.foodway.domain.signUp.repository.ISignUpRepository
import com.example.foodway.utils.validateField

class CreateUserUseCase(
    private val repository : ISignUpRepository
) {
    suspend operator fun invoke(signUpEstablishment: SignUpEstablishment) {
        try {
            with(signUpEstablishment) {
                validateField(fantasyName, "Fantasy name")
                validateField(responsible, "Responsible")
                validateField(email, "Email")
                validateField(password, "Password")
                validateField(cnpj, "Cnpj")
                validateField(cep, "Cep")
                validateField(number, "Number")
                validateField(categories, "Categories")
            }
            val response = repository.create(signUpEstablishment = signUpEstablishment)
            if (response.isSuccessful) {
                return response.body() ?: throw Exception("Response body is null")
            } else {
                throw Exception(response.errorBody().toString())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    suspend operator fun invoke(signUpCustomer: SignUpCustomer) {
        try {
            with(signUpCustomer) {
                validateField(name, "Name")
                validateField(lastName, "Last name")
                validateField(cpf, "CPF")
                validateField(email, "Email")
                validateField(password, "Password")
                validateField(categories, "Categories")
            }
            val response = repository.create(signUpCustomer = signUpCustomer)
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