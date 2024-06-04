package com.example.foodway.data.edit.remote

import com.example.foodway.domain.edit.repository.IUploadFileRepository
import okhttp3.MultipartBody
import retrofit2.Response

class UploadFileRepositoryImpl(
    private val api: UploadFileService
) : IUploadFileRepository{
    override suspend fun upload(image: MultipartBody.Part): Response<Unit> {
       return api.upload(image)
    }
}