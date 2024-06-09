package com.example.foodway.domain.edit.repository

import okhttp3.MultipartBody
import retrofit2.Response

interface IUploadFileRepository {
    suspend fun upload(
        formData: List<MultipartBody.Part>,
        token: String
    ): Response<Unit>
}
