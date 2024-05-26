package com.example.foodway.di

import com.example.foodway.data.network.ApiConfig
import com.example.foodway.data.signUp.remote.CulinaryService
import com.example.foodway.data.remote.CustomerService
import com.example.foodway.data.remote.EstablishmentService
import com.example.foodway.data.establishmentMenu.remote.ProductService
import com.example.foodway.data.searchUser.remote.SearchUserService
import com.example.foodway.data.signIn.remote.SignInService
import org.koin.dsl.module

val dataModule = module {
    single<SignInService> {
        ApiConfig
            .getInstance()
            .create(SignInService::class.java)
    }

    single<SearchUserService> {
        ApiConfig
            .getInstance()
            .create(SearchUserService::class.java)
    }

    single<ProductService> {
        ApiConfig
            .getInstance()
            .create(ProductService::class.java)
    }

    single<CulinaryService> {
        ApiConfig
            .getInstance()
            .create(CulinaryService::class.java)
    }

    single<CustomerService> {
        ApiConfig
            .getInstance()
            .create(CustomerService::class.java)
    }

    single<EstablishmentService> {
        ApiConfig
            .getInstance()
            .create(EstablishmentService::class.java)
    }
}