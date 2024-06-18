package com.example.foodway.data.edit.remote

import com.example.foodway.domain.edit.repository.IUploadFileRepository
import okhttp3.MultipartBody

class UploadFileRepositoryImpl(
    private val api: UploadFileService
) : IUploadFileRepository {
    override suspend fun upload(
        formData: List<MultipartBody.Part>,
        token: String
    ): String {
        return api.upload(
            parts = formData, token = token
        )
    }
}