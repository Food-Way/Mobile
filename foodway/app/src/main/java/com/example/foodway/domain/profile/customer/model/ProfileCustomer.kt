package com.example.foodway.domain.profile.customer.model

import com.example.foodway.model.EstablishmentCard
import com.google.gson.annotations.SerializedName

data class ProfileCustomer(
    val name: String,
    val bio: String,
    val profilePhoto: String,
    val level: Int,
    val xp: Double,
    val profileRate: Double,
    val qtdComments: Int,
    val qtdUpvotes: Int,

    @SerializedName("comments")
    val recentEstablishment: List<EstablishmentCard>,

    @SerializedName("establishmentDTOs")
    val favoriteEstablishment: List<EstablishmentCard>
)
