package com.example.foodway.domain.model

import java.util.UUID

data class CommentChild(
    val idComment: UUID,
    val image: String,
    val name: String,
    val comment: String,
    val qtdUpvotes: Int,
)
