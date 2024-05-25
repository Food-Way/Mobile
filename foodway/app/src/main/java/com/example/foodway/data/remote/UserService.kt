package com.example.foodway.data.remote

import com.example.foodway.domain.signIn.model.SignIn
import com.example.foodway.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("users/login")
    suspend fun login(@Body signIn: SignIn): Response<User>
}