package com.example.foodway.domain.edit.establishment.model

data class EditEstablishmentAccount(
    val name: String,
    val email: String,
    val newEmail: String,
    val password: String,
    val newPassword: String,
    val cep: String,
)
