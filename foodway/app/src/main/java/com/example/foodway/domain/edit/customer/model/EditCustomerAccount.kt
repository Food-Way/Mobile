package com.example.foodway.domain.edit.customer.model

data class EditCustomerAccount(
    val emailActual: String,
    val emailNew: String,
    val password: String,
    val passwordNew: String
)
