package com.example.foodway.model

import java.util.UUID

data class Comment(
    val idComment: UUID,
    val image: String,
    val name: String,
    val comment: String,
    val rate: Double,
    val qtdUpvotes: Int,
    val commentChild: List<CommentChild>? = null
)