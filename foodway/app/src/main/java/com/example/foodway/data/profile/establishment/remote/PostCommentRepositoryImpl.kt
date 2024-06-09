package com.example.foodway.data.profile.establishment.remote

import com.example.foodway.domain.profile.establishment.model.PostComment
import com.example.foodway.domain.profile.establishment.repository.IPostCommentRepository
import retrofit2.Response

class PostCommentRepositoryImpl(
    private val api: PostCommentService
) : IPostCommentRepository {
    override suspend fun create(token: String, postComment: PostComment): Response<Unit> {
        return api.postComment(token, postComment)
    }
}