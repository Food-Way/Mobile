package com.example.foodway.domain.profile.establishment.model

import com.google.gson.annotations.SerializedName

data class Rate(
    @SerializedName("name")
    val name: String,
    @SerializedName("ratePoint")
    val ratePoint: Double
)