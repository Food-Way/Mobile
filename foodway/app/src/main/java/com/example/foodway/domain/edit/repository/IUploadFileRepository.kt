package com.example.foodway.domain.edit.repository

import okhttp3.MultipartBody

interface IUploadFileRepository {
    suspend fun upload(
        formData: List<MultipartBody.Part>,
        token: String
    ): String
}
