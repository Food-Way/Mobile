package com.example.foodway.di

import android.content.Context
import android.content.SharedPreferences
import com.example.foodway.data.remote.CulinaryRepositoryImpl
import com.example.foodway.data.remote.CustomerRepositoryImpl
import com.example.foodway.data.remote.EstablishmentRepositoryImpl
import com.example.foodway.domain.repository.ICulinaryRepository
import com.example.foodway.domain.repository.ICustomerRepository
import com.example.foodway.domain.repository.IEstablishmentRepository
import com.example.foodway.domain.repository.IProductRepository
import com.example.foodway.domain.signIn.repository.ISignInRepository
import com.example.foodway.data.remote.ProductRepositoryImpl
import com.example.foodway.data.signIn.remote.SignInRepositoryImpl
import com.example.foodway.viewModel.MenuEstablishmentViewModel
import com.example.foodway.viewModel.ProfileCustomerViewModel
import com.example.foodway.viewModel.ProfileEstablishmentViewModel
import com.example.foodway.viewModel.SignInViewModel
import com.example.foodway.viewModel.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<SharedPreferences> {
        get<Context>().getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
    }

    single<ICulinaryRepository> {
        CulinaryRepositoryImpl()
    }

    single<IProductRepository> {
        ProductRepositoryImpl()
    }

    single<ICustomerRepository> {
        CustomerRepositoryImpl()
    }

    single<IEstablishmentRepository> {
        EstablishmentRepositoryImpl()
    }

    single<ISignInRepository> {
        SignInRepositoryImpl()
    }

    viewModel {
        SignUpViewModel(
            culinaryRepository = get(),
            customerRepository = get(),
            establishmentRepository = get(),
        )
    }

    viewModel {
        MenuEstablishmentViewModel(get())
    }

    viewModel {
        ProfileCustomerViewModel(get())
    }

    viewModel {
        ProfileEstablishmentViewModel(get())
    }

    viewModel {
        SignInViewModel(
            repository = get(),
            sharedPreferences = get()
        )
    }
}