package com.example.foodway.data.remote

import com.example.foodway.model.Upvote
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PATCH

interface UpvoteService {
    @PATCH("upvotes")
    suspend fun upvote(@Body upvotesBody: Upvote): Response<Unit>
}