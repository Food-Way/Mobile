package com.example.foodway.domain.profile.establishment.repository

import com.example.foodway.domain.profile.establishment.model.PatchUpvote
import com.example.foodway.domain.profile.establishment.model.PostComment
import com.example.foodway.domain.profile.establishment.model.PostCommentChild
import com.example.foodway.domain.profile.establishment.model.PostRate
import retrofit2.Response

interface ICommentRepository {
    suspend fun create(
        token: String,
        postComment: PostComment
    ): Response<Unit>

    suspend fun create(
        token: String,
        postCommentChild: PostCommentChild
    ): Response<Unit>

    suspend fun patchUpvote(
        token: String,
        patchUpvote: PatchUpvote
    ): Response<Unit>

    suspend fun createRate(
        token: String,
        rates: PostRate
    ): Response<Unit>
}