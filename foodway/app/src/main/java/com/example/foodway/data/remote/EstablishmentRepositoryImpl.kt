package com.example.foodway.data.remote

import com.example.foodway.domain.edit.establishment.model.EditEstablishmentAccount
import com.example.foodway.domain.edit.establishment.model.EditEstablishmentProfile
import com.example.foodway.domain.edit.establishment.model.GetProfileEstablishmentEdit
import com.example.foodway.domain.profile.establishment.model.ProfileEstablishment
import com.example.foodway.domain.repository.IEstablishmentRepository
import retrofit2.Response
import java.util.UUID

class EstablishmentRepositoryImpl(
    private val api: EstablishmentService
) : IEstablishmentRepository {
    override suspend fun getEstablishmentProfile(
        idEstablishment: UUID
    ): Response<ProfileEstablishment> {
        return api.getEstablishmentProfile(idEstablishment)
    }

    override suspend fun getEstablishment(idEstablishment: UUID): Response<GetProfileEstablishmentEdit> {
        return api.getEstablishment(idEstablishment)
    }

    override suspend fun updateAccount(
        idEstablishment: UUID,
        editEstablishmentAccount: EditEstablishmentAccount
    ): Response<Unit> {
        return api.updateCustomerPersonalInfo(
            idEstablishment = idEstablishment,
            editEstablishmentAccount = editEstablishmentAccount
        )
    }

    override suspend fun updateProfile(
        idEstablishment: UUID,
        editEstablishmentProfile: EditEstablishmentProfile
    ): Response<Unit> {
        return api.updateCustomerProfileInfo(
            idEstablishment = idEstablishment,
            editEstablishmentProfile = editEstablishmentProfile
        )
    }


}