package com.example.foodway.data.profile.establishment.remote

import com.example.foodway.domain.profile.establishment.model.PostComment
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface PostCommentService {
    @POST("comments")
    suspend fun postComment(
        @Header("Authorization") token: String,
        @Body postComment: PostComment
    ): Response<Unit>
}