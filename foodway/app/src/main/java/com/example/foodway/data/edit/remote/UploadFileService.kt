package com.example.foodway.data.edit.remote

import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface UploadFileService {
    @Multipart
    @POST("files/upload-profile")
    suspend fun upload(
        @Part parts: List<MultipartBody.Part>,
        @Header("Authorization") token: String
    ): Response<Unit>
}