package com.example.foodway.di

import android.content.Context
import android.content.SharedPreferences
import com.example.foodway.repository.CulinaryRepositoryImpl
import com.example.foodway.repository.CustomerRepositoryImpl
import com.example.foodway.repository.EstablishmentRepositoryImpl
import com.example.foodway.repository.ICulinaryRepository
import com.example.foodway.repository.ICustomerRepository
import com.example.foodway.repository.IEstablishmentRepository
import com.example.foodway.repository.IProductRepository
import com.example.foodway.repository.ISearchUserRepository
import com.example.foodway.repository.ISignInRepository
import com.example.foodway.repository.ProductRepositoryImpl
import com.example.foodway.repository.SearchUserRepositoryImpl
import com.example.foodway.repository.SignInRepositoryImpl
import com.example.foodway.viewModel.MenuEstablishmentViewModel
import com.example.foodway.viewModel.ProfileCustomerViewModel
import com.example.foodway.viewModel.ProfileEstablishmentViewModel
import com.example.foodway.viewModel.SearchUserViewModel
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

    single<ISearchUserRepository> {
        SearchUserRepositoryImpl()
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
        SearchUserViewModel(get())
    }

    viewModel {
        SignInViewModel(
            repository = get(),
            sharedPreferences = get()
        )
    }
}