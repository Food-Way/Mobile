package com.example.foodway.domain.model

import java.util.UUID

data class CommentChild(
    val idPost: UUID,
    val userPhoto: String,
    val userName: String,
    val comment: String,
    val upvotes: Int,
)
