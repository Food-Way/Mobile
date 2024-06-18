package com.example.foodway.domain.model

import java.util.UUID

data class Comment(
    val idPost: UUID,
    val userPhoto: String,
    val comment: String,
    val generalRate: Double,
    val upvotes: Int,
    val replies: List<CommentChild>? = null
)
