package com.example.foodway.domain.edit.establishment.model

data class EditEstablishmentProfile(
    val establishmentName: String,
    val phone: String,
    var description: String,
    var profilePhoto: String
)