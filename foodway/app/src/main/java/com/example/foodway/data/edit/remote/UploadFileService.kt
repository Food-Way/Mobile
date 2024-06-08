package com.example.foodway.data.edit.remote

import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface UploadFileService {
    @Multipart
    @POST("files/upload")
    suspend fun upload(
        @Part image: MultipartBody.Part,
        @Part path: MultipartBody.Part,
        @Part typeUser: MultipartBody.Part
    ): Response<Unit>
}