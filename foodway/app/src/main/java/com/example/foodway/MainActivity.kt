package com.example.foodway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodway.di.appModule
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.navigation.AppDestination
import com.example.foodway.view.profileCustomer.ProfileCustomerActivity
import com.example.foodway.view.profileEstablishment.ProfileEstablishmentActivity
import com.example.foodway.view.signUp.customer.StepOneCustomerActivity
import com.example.foodway.view.signUp.establishment.StepFourEstablishmentActivity
import com.example.foodway.view.signUp.establishment.StepOneEstablishmentActivity
import com.example.foodway.view.signUp.establishment.StepThreeEstablishmentActivity
//import com.example.foodway.view.signUp.establishment.StepThreeEstablishmentActivity
import com.example.foodway.view.signUp.establishment.StepTwoEstablishmentActivity
import com.example.foodway.view.welcome.WelcomeActivity
import com.example.foodway.viewModel.SignUpViewModel
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            androidContext(this@MainActivity)
            modules(appModule)
        }
        setContent {
            val navController = rememberNavController()
            val signUpViewModel: SignUpViewModel by inject()

            MainApp(navController, signUpViewModel)
        }
    }
}

@Composable
fun MainApp(navController: NavHostController, signUpViewModel: SignUpViewModel) {
    FoodwayTheme {
        NavHost(
            navController = navController,
            startDestination = AppDestination.StepOneSignUpEstablishment.route
        ) {
            composable(AppDestination.Welcome.route) {
                WelcomeActivity()
            }
            composable(AppDestination.ProfileCustomer.route) {
                ProfileCustomerActivity()
            }
            composable(AppDestination.ProfileEstablishment.route) {
                ProfileEstablishmentActivity()
            }
            composable(AppDestination.StepOneSignUpCustomer.route) {
                StepOneCustomerActivity()
            }
            composable(AppDestination.StepOneSignUpEstablishment.route) {
                StepOneEstablishmentActivity(
                    onNavigate = {
                        navController.navigate(AppDestination.StepTwoSignUpEstablishment.route)
                    }
                )
            }
            composable(AppDestination.StepTwoSignUpEstablishment.route) {
                StepTwoEstablishmentActivity(
                    onNavigate = {
                        navController.navigate(AppDestination.StepThreeSignUpEstablishment.route)
                    }
                )
            }
            composable(AppDestination.StepThreeSignUpEstablishment.route) {
                StepThreeEstablishmentActivity(
//                    onNavigate = {
//                        navController.navigate(AppDestination.StepFourSignUpEstablishment.route)
//                    },
                    vm = signUpViewModel
                )
            }
            composable(AppDestination.StepFourSignUpEstablishment.route) {
                StepFourEstablishmentActivity(
                    onNavigate = {
                        navController.navigate(AppDestination.ProfileCustomer.route)
                    }
                )
            }
        }
    }
}

//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MainApp()
//}
