package com.example.foodway.repository

import com.example.foodway.model.Customer
import com.example.foodway.model.Login
import retrofit2.Response

interface ISignInRepository{
    suspend fun login(login: Login): Response<Customer>
}