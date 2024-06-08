package com.example.foodway.domain.repository

import com.example.foodway.domain.edit.establishment.model.EditEstablishmentAccount
import com.example.foodway.domain.edit.establishment.model.EditEstablishmentProfile
import com.example.foodway.domain.edit.establishment.model.GetProfileEstablishmentEdit
import com.example.foodway.domain.profile.establishment.model.ProfileEstablishment
import retrofit2.Response
import java.util.UUID

interface IEstablishmentRepository {
    suspend fun getEstablishmentProfile(idEstablishment: UUID): Response<ProfileEstablishment>
    suspend fun getEstablishment(idEstablishment: UUID): Response<GetProfileEstablishmentEdit>
    suspend fun updateAccount(idEstablishment: UUID, editEstablishmentAccount: EditEstablishmentAccount): Response<Unit>
    suspend fun updateProfile(idEstablishment: UUID, editEstablishmentProfile: EditEstablishmentProfile): Response<Unit>
}