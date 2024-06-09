package com.example.foodway.domain.edit.establishment.model

import java.util.UUID

data class GetProfileEstablishmentEdit(
    val idUser: UUID,
    val name: String,
    val establishmentName: String,
    val email: String,
    val description: String,
    val phone: String,
    val profilePhoto: String,
)