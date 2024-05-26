package com.example.foodway.data.profile.establishment.remote

import com.example.foodway.domain.model.Upvote
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PATCH

interface UpvoteService {
    @PATCH("upvotes")
    suspend fun updateUpvote(@Body upvotesBody: Upvote): Response<Unit>
}