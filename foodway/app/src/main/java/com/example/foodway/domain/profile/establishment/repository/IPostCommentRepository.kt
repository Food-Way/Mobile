package com.example.foodway.domain.profile.establishment.repository

import com.example.foodway.domain.profile.establishment.model.PostComment
import retrofit2.Response

interface IPostCommentRepository {
    suspend fun create(
        postComment: PostComment
    ): Response<Unit>
}