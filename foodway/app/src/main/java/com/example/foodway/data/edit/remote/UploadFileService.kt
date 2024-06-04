package com.example.foodway.data.edit.remote

import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST

interface UploadFileService {
    @Multipart
    @POST("files/upload")
    fun upload(image: MultipartBody.Part): Response<Unit>
}