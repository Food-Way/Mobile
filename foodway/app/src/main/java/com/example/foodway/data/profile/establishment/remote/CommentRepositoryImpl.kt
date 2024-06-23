package com.example.foodway.data.profile.establishment.remote

import com.example.foodway.domain.profile.establishment.model.PatchUpvote
import com.example.foodway.domain.profile.establishment.model.PostComment
import com.example.foodway.domain.profile.establishment.model.PostCommentChild
import com.example.foodway.domain.profile.establishment.model.PostRate
import com.example.foodway.domain.profile.establishment.repository.ICommentRepository
import retrofit2.Response

class CommentRepositoryImpl(
    private val api: CommentService
) : ICommentRepository {

    override suspend fun create(
        token: String,
        postComment: PostComment
    ): Response<Unit> {
        return api.postComment(token, postComment)
    }

    override suspend fun create(
        token: String,
        postCommentChild: PostCommentChild
    ): Response<Unit> {
        return api.postComment(token, postCommentChild)
    }

    override suspend fun patchUpvote(
        token: String,
        patchUpvote: PatchUpvote
    ): Response<Unit> {
        return api.patchUpvote(token, patchUpvote)
    }

    override suspend fun createRate(
        token: String,
        rates: PostRate
    ): Response<Unit> {
        return api.postRate(token, rates)
    }
}