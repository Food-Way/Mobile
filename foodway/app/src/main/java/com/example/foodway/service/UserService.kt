package com.example.foodway.service

import com.example.foodway.model.Login
import com.example.foodway.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("/users/login")
    suspend fun login(@Body login: Login): Response<User>
}