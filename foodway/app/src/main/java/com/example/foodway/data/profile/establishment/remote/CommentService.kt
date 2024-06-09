package com.example.foodway.data.profile.establishment.remote

import com.example.foodway.domain.profile.establishment.model.PatchUpvote
import com.example.foodway.domain.profile.establishment.model.PostComment
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST

interface CommentService {
    @POST("comments")
    suspend fun postComment(
        @Header("Authorization") token: String,
        @Body postComment: PostComment
    ): Response<Unit>

    @PATCH("upvotes")
    suspend fun patchUpvote(
        @Header("Authorization") token: String,
        @Body patchUpvote: PatchUpvote
    ): Response<Unit>

}