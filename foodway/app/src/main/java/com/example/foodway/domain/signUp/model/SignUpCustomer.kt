package com.example.foodway.domain.signUp.model

import com.example.foodway.domain.model.Culinary

data class SignUpCustomer (
    val name: String,
    val lastName: String,
    val cpf: String,
    val email: String,
    val password: String,
    val categories: List<Culinary>,
)