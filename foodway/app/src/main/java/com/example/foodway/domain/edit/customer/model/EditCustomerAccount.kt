package com.example.foodway.domain.edit.customer.model

data class EditCustomerAccount(
    val name: String,
    val email: String,
    val newEmail: String,
    val password: String,
    val newPassword: String
)
