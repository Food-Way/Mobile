package com.example.foodway.domain.edit.establishment.model

data class EditEstablishmentProfile(
    val emailActual: String,
    val passwordActual: String,
    var profilePhoto: String,
    val profileHeaderImg: String
)
