package com.example.foodway.domain.model

import java.util.UUID

data class Comment(
    val idComment: UUID,
    val photo: String,
    val name: String,
    val comment: String,
    val rate: Double,
    val qtdUpvotes: Int,
    val commentChild: List<CommentChild>? = null
)
