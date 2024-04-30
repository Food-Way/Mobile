package com.example.foodway.model

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