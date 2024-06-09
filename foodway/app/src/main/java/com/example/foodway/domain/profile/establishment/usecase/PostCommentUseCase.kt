package com.example.foodway.domain.profile.establishment.usecase

import com.example.foodway.domain.profile.establishment.model.PostComment
import com.example.foodway.domain.profile.establishment.repository.IPostCommentRepository
import com.example.foodway.utils.validateField

class PostCommentUseCase(
    private val repository: IPostCommentRepository
) {
    suspend operator fun invoke(token: String, postComment: PostComment) {
        try {
            with(postComment) {
                validateField(comment, "Comment")
            }
            val response = repository.create(token = token,postComment = postComment)
            if (response.isSuccessful) {
                return response.body() ?: throw Exception("Response body is null")
            } else {
                throw Exception(response.errorBody().toString())
            }
        } catch (e: Exception) {
            throw e
        }
    }
}