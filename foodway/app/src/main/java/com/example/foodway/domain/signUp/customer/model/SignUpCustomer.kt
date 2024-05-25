package com.example.foodway.domain.signUp.customer.model

import com.example.foodway.model.Culinary

data class SignUpCustomer (
    val name: String,
    val lastName: String,
    val cpf: String,
    val email: String,
    val password: String,
    val categories: List<Culinary>

) {
    val typeUser: String get() = "CLIENT"
}