package com.example.foodway.view.navigation

sealed class AppDestination(val route: String) {
    object ProfileCustomer: AppDestination("profileCustomerActivity")
    object ProfileEstablishment: AppDestination("profileEstablishmentActivity")
    object StepOneSignUpCustomer: AppDestination("stepOneCustomerActivity")
    object StepTwoSignUpCustomer: AppDestination("stepTwoCustomerActivity")
    object StepThreeSignUpCustomer: AppDestination("stepThreeCustomerActivity")
    object StepFourSignUpCustomer: AppDestination("stepFourCustomerActivity")
    object StepOneSignUpEstablishment: AppDestination("stepOneEstablishmentActivity")
    object StepTwoSignUpEstablishment: AppDestination("stepTwoEstablishmentActivity")
    object StepThreeSignUpEstablishment: AppDestination("stepThreeEstablishmentActivity")
    object StepFourSignUpEstablishment: AppDestination("stepFourEstablishmentActivity")
    object Welcome: AppDestination("welcomeActivity")
    object MenuEstablishment: AppDestination("menuEstablishmentActivity")
    object SignIn: AppDestination("signIn")
}