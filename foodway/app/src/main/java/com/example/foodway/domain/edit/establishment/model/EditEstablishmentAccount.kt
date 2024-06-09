package com.example.foodway.domain.edit.establishment.model

data class EditEstablishmentAccount (
    val name: String,
    val establishmentName: String,
    val emailActual: String,
    val emailNew: String,
    val passwordActual: String,
    val passwordNew: String,
    val phone: String,
    val description: String
)
