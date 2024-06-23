package com.example.foodway.domain.profile.establishment.model

import com.example.foodway.domain.model.Comment
import com.google.gson.annotations.SerializedName
import java.util.UUID

data class ProfileEstablishment(
    val idEstablishment: UUID,
    val name: String,
    val establishmentName: String,
    val email: String,
    val culinary: String,
    val generalRate: Double,
    val qtdComments: Int,
    val qtdUpvotes: Int,
    @SerializedName("comments")
    val comments: List<Comment>,
)
