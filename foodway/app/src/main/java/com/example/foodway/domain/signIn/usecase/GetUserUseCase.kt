package com.example.foodway.domain.signIn.usecase

import com.example.foodway.domain.signIn.model.AuthResponse
import com.example.foodway.domain.signIn.model.SignIn
import com.example.foodway.domain.signIn.repository.ISignInRepository
import com.example.foodway.utils.validateField

class GetUserUseCase(
    private val repository: ISignInRepository
) {
    suspend operator fun invoke(signIn: SignIn): AuthResponse {
        try {
            with(signIn) {
                validateField(email, "Email")
                validateField(password, "Password")
            }
            val response = repository.create(signIn = signIn)
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