package com.example.foodway.domain.profile.establishment.repository

import com.example.foodway.domain.profile.establishment.model.PatchUpvote
import com.example.foodway.domain.profile.establishment.model.PostComment
import retrofit2.Response

interface ICommentRepository {
    suspend fun create(
        token: String,
        postComment: PostComment
    ): Response<Unit>

    suspend fun patchUpvote(
        token: String,
        patchUpvote: PatchUpvote
    ): Response<Unit>
}