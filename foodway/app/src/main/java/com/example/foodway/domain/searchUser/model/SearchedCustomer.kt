package com.example.foodway.domain.searchUser.model

import com.example.foodway.domain.model.ETypeUser
import java.util.UUID

class SearchedCustomer (
    val idCustomer: UUID,
    val name: String,
    val typeUser: ETypeUser,
    val culinary: String,
    val generalRate: Double,
    val bio: String,
    val upvotes: Int,
    val qtdComments: Int,
    val photo: String
)