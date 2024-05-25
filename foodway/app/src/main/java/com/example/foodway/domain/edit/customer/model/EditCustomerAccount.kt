package com.example.foodway.domain.edit.customer.model

data class EditCustomerAccount(
    val name: String,
    val lastName: String,
    val cpf: String,
    val email: String,
    val password: String
)
