package com.example.foodway.domain.profile.establishment.usecase

import com.example.foodway.domain.profile.establishment.model.PatchUpvote
import com.example.foodway.domain.profile.establishment.repository.ICommentRepository

class PatchUpvoteUseCase(
    private val repository: ICommentRepository
) {
    suspend operator fun invoke(
        patchUpvote: PatchUpvote,
        token: String
    ) {
        try {
            val response = repository.patchUpvote(
                token = token,
                patchUpvote = patchUpvote
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