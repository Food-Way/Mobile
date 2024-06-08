package com.example.foodway.domain.profile.establishment.model

data class PostComment(
    val idCustomer: String,
    val idEstablishment: String,
    val comment: String,
    val userPhoto: String,
    val userName: String,
    val typeUser: String,
    val images: List<String> = emptyList()
)