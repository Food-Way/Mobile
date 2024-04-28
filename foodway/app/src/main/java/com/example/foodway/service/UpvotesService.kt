package com.example.foodway.service

import com.example.foodway.model.Upvote
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PATCH

interface UpvotesService {
    @PATCH("upvotes")
    suspend fun upvote(@Body upvotesBody: Upvote): Response<Unit>
}