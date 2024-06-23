package com.example.foodway.di

import com.example.foodway.data.edit.remote.UploadFileRepositoryImpl
import com.example.foodway.data.establishmentMenu.remote.ProductRepositoryImpl
import com.example.foodway.data.profile.establishment.remote.CommentRepositoryImpl
import com.example.foodway.data.remote.CustomerRepositoryImpl
import com.example.foodway.data.remote.EstablishmentRepositoryImpl
import com.example.foodway.data.searchUser.remote.SearchUserRepositoryImpl
import com.example.foodway.data.signIn.remote.SignInRepositoryImpl
import com.example.foodway.data.signUp.remote.CulinaryRepositoryImpl
import com.example.foodway.data.signUp.remote.SignUpRepositoryImpl
import com.example.foodway.domain.edit.customer.usecase.GetCustomerAccountUseCase
import com.example.foodway.domain.edit.establishment.repository.GetEstablishmentAccountUseCase
import com.example.foodway.domain.edit.repository.IUploadFileRepository
import com.example.foodway.domain.edit.usecase.PostImageUseCase
import com.example.foodway.domain.edit.usecase.UpdateAccountUseCase
import com.example.foodway.domain.edit.usecase.UpdateProfileUseCase
import com.example.foodway.domain.establishmentMenu.usecase.GetEstablishmentMenuUseCase
import com.example.foodway.domain.profile.customer.usecase.GetCustomerProfileUseCase
import com.example.foodway.domain.profile.establishment.repository.ICommentRepository
import com.example.foodway.domain.profile.establishment.usecase.GetEstablishmentProfileUseCase
import com.example.foodway.domain.profile.establishment.usecase.PatchUpvoteUseCase
import com.example.foodway.domain.profile.establishment.usecase.PostCommentUseCase
import com.example.foodway.domain.profile.establishment.usecase.PostRateUseCase
import com.example.foodway.domain.repository.ICulinaryRepository
import com.example.foodway.domain.repository.ICustomerRepository
import com.example.foodway.domain.repository.IEstablishmentRepository
import com.example.foodway.domain.repository.IProductRepository
import com.example.foodway.domain.searchUser.repository.ISearchUserRepository
import com.example.foodway.domain.searchUser.usecase.GetCustomerUseCase
import com.example.foodway.domain.searchUser.usecase.GetEstablishmentUseCase
import com.example.foodway.domain.searchUser.usecase.PatchFavoriteUseCase
import com.example.foodway.domain.signIn.repository.ISignInRepository
import com.example.foodway.domain.signIn.usecase.GetUserUseCase
import com.example.foodway.domain.signUp.repository.ISignUpRepository
import com.example.foodway.domain.signUp.usecase.CreateUserUseCase
import com.example.foodway.domain.signUp.usecase.GetAllCulinariesUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<ICulinaryRepository> {
        CulinaryRepositoryImpl(
            api = get()
        )
    }

    single<IProductRepository> {
        ProductRepositoryImpl(
            api = get()
        )
    }

    factory {
        GetEstablishmentMenuUseCase(
            repository = get()
        )
    }


    single<ICustomerRepository> {
        CustomerRepositoryImpl(
            api = get()
        )
    }

    single {
        GetCustomerProfileUseCase(
            repository = get()
        )
    }


    single<IEstablishmentRepository> {
        EstablishmentRepositoryImpl(
            api = get()
        )
    }

    single {
        GetEstablishmentProfileUseCase(
            repository = get()
        )
    }

    single {
        GetEstablishmentAccountUseCase(
            establishmentRepository = get()
        )
    }


    factory<ISearchUserRepository> {
        SearchUserRepositoryImpl(
            api = get()
        )
    }

    single {
        GetCustomerUseCase(
            repository = get()
        )
    }

    single {
        GetEstablishmentUseCase(
            repository = get()
        )
    }

    single {
        PatchFavoriteUseCase(
            repository = get()
        )
    }


    single<ISignInRepository> {
        SignInRepositoryImpl(
            api = get()
        )
    }

    single {
        GetUserUseCase(
            repository = get()
        )
    }

    factory<ISignUpRepository> {
        SignUpRepositoryImpl(
            api = get()
        )
    }

    single {
        CreateUserUseCase(
            repository = get()
        )
    }

    single {
        GetAllCulinariesUseCase(
            repository = get()
        )
    }

    single<IUploadFileRepository> {
        UploadFileRepositoryImpl(
            api = get()
        )
    }

    single {
        PostImageUseCase(
            uploadFileRepository = get()
        )
    }
    single {
        UpdateAccountUseCase(
            establishmentRepository = get(),
            customerRepository = get()
        )
    }
    single {
        UpdateProfileUseCase(
            establishmentRepository = get(),
            customerRepository = get()
        )
    }
    single {
        GetCustomerAccountUseCase(
            customerRepository = get()
        )
    }

    single<ICommentRepository> {
        CommentRepositoryImpl(
            api = get()
        )
    }

    factory {
        PostCommentUseCase(
            repository = get()
        )
    }

    single {
        PatchUpvoteUseCase(
            repository = get()
        )
    }

    factory {
        PostRateUseCase(
            repository = get()
        )
    }
}

