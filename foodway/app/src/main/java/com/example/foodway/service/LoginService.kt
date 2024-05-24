package com.example.foodway.service

import com.example.foodway.model.AuthResponse
import com.example.foodway.model.Login
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("users/login")
    suspend fun login(@Body login: Login): Response<AuthResponse>
}