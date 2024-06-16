package com.example.foodway.domain.profile.establishment.usecase

import com.example.foodway.domain.profile.establishment.model.PostComment
import com.example.foodway.domain.profile.establishment.model.PostCommentChild
import com.example.foodway.domain.profile.establishment.repository.ICommentRepository
import com.example.foodway.utils.validateField

class PostCommentUseCase(
    private val repository: ICommentRepository
) {
    suspend operator fun invoke(
        postComment: PostComment,
        token: String,
    ) {
        try {
            with(postComment) {
                validateField(comment, "Comment")
            }
            val response = repository.create(
                token = token,
                postComment = postComment
            )
            if (response.isSuccessful) {
                return response.body() ?: throw Exception("Response body is null")
            } else {
                throw Exception(response.errorBody().toString())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    suspend operator fun invoke(
        postCommentChild: PostCommentChild,
        token: String
    ) {
        try {
            with(postCommentChild) {
                validateField(comment, "Comment")
            }
            val response = repository.create(
                token = token,
                postCommentChild = postCommentChild
            )
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
