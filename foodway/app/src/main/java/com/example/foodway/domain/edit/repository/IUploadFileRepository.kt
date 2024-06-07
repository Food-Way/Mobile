package com.example.foodway.domain.edit.repository

import okhttp3.MultipartBody
import retrofit2.Response

interface IUploadFileRepository {
    suspend fun upload(
        image: MultipartBody.Part,
        pathPart: MultipartBody.Part,
        typePart: MultipartBody.Part
    ): Response<Unit>
}
