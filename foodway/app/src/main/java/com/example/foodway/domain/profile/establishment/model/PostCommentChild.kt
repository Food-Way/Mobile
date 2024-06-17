package com.example.foodway.domain.profile.establishment.model

import com.example.foodway.domain.model.ETypeUser
import java.util.UUID

data class PostCommentChild(
    val idCustomer: UUID,
    val idEstablishment: UUID,
    val idParent: UUID,
    val comment: String,
    val userPhoto: String,
    val userName: String,
    val typeUser: ETypeUser,
    val images: List<String> = emptyList()
)
