package com.example.foodway.di

import com.example.foodway.data.establishmentMenu.remote.ProductRepositoryImpl
import com.example.foodway.data.remote.CustomerRepositoryImpl
import com.example.foodway.data.remote.EstablishmentRepositoryImpl
import com.example.foodway.data.searchUser.remote.SearchUserRepositoryImpl
import com.example.foodway.data.signIn.remote.SignInRepositoryImpl
import com.example.foodway.data.signUp.remote.CulinaryRepositoryImpl
import com.example.foodway.domain.establishmentMenu.usecase.GetEstablishmentMenuUseCase
import com.example.foodway.domain.profile.customer.usecase.GetCustomerProfileUseCase
import com.example.foodway.domain.profile.establishment.usecase.GetEstablishmentProfileUseCase
import com.example.foodway.domain.repository.ICulinaryRepository
import com.example.foodway.domain.repository.ICustomerRepository
import com.example.foodway.domain.repository.IEstablishmentRepository
import com.example.foodway.domain.repository.IProductRepository
import com.example.foodway.domain.searchUser.repository.ISearchUserRepository
import com.example.foodway.domain.searchUser.usecase.GetCustomerUseCase
import com.example.foodway.domain.searchUser.usecase.GetEstablishmentUseCase
import com.example.foodway.domain.searchUser.usecase.GetFavoriteUseCase
import com.example.foodway.domain.signIn.repository.ISignInRepository
import com.example.foodway.domain.signIn.usecase.GetUserUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<ICulinaryRepository> {
        CulinaryRepositoryImpl(get())
    }

    single<IProductRepository> {
        ProductRepositoryImpl(get())
    }

    single {
        GetEstablishmentMenuUseCase(get())
    }


    single<ICustomerRepository> {
        CustomerRepositoryImpl(get())
    }

    single {
        GetCustomerProfileUseCase(get())
    }


    single<IEstablishmentRepository> {
        EstablishmentRepositoryImpl(get())
    }

    single {
        GetEstablishmentProfileUseCase(get())
    }


    single<ISearchUserRepository> {
        SearchUserRepositoryImpl(get())
    }

    single {
        GetCustomerUseCase(get())
    }

    single {
        GetEstablishmentUseCase(get())
    }

    single {
        GetFavoriteUseCase(get())
    }


    single<ISignInRepository> {
        SignInRepositoryImpl(get())
    }

    single {
        GetUserUseCase(get())
    }
}

