package com.example.foodway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodway.di.appModule
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.establishmentMenu.MenuEstablishment
import com.example.foodway.view.navigation.AppDestination
import com.example.foodway.view.profileCustomer.ProfileCustomer
import com.example.foodway.view.profileEstablishment.ProfileEstablishment
import com.example.foodway.view.signUp.customer.StepOneCustomer
import com.example.foodway.view.signUp.customer.StepThreeCustomer
import com.example.foodway.view.signUp.customer.StepTwoCustomer
import com.example.foodway.view.signUp.establishment.StepFourEstablishment
import com.example.foodway.view.signUp.establishment.StepOneEstablishment
import com.example.foodway.view.signUp.establishment.StepThreeEstablishment
import com.example.foodway.view.signUp.establishment.StepTwoEstablishment
import com.example.foodway.view.welcome.Welcome
import com.example.foodway.viewModel.MenuEstablishmentViewModel
import com.example.foodway.viewModel.ProfileCustomerViewModel
import com.example.foodway.viewModel.ProfileEstablishmentViewModel
import com.example.foodway.viewModel.SignUpViewModel
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            FoodwayTheme {
                MainApp {
                    NavHost(
                        navController = navController,
                        startDestination = AppDestination.ProfileEstablishment.route
                    ) {
                        composable(AppDestination.Welcome.route) {
                            Welcome()
                        }
                        composable(AppDestination.ProfileCustomer.route) {
                            val vm by inject<ProfileCustomerViewModel>()
                            ProfileCustomer(
                                vm = vm
                            )
                        }
                        composable(AppDestination.ProfileEstablishment.route) {
                            val vm by inject<ProfileEstablishmentViewModel>()
                            ProfileEstablishment(
                                vm = vm
                            )
                        }
                        composable(AppDestination.StepOneSignUpCustomer.route) {
                            StepOneCustomer(
                                onNavigate = {
                                    navController.navigate(AppDestination.StepTwoSignUpCustomer.route)
                                }
                            )
                        }
                        composable(AppDestination.StepTwoSignUpCustomer.route) {
                            val vm by inject<SignUpViewModel>()
                            StepTwoCustomer(
                                onNavigate = {
                                    navController.navigate(AppDestination.StepThreeSignUpCustomer.route)
                                },
                                vm = vm
                            )
                        }
                        composable(AppDestination.StepThreeSignUpCustomer.route) {
                            StepThreeCustomer()
                        }
                        composable(AppDestination.StepOneSignUpEstablishment.route) {
                            StepOneEstablishment(
                                onNavigate = {
                                    navController.navigate(AppDestination.StepTwoSignUpEstablishment.route)
                                }
                            )
                        }
                        composable(AppDestination.StepTwoSignUpEstablishment.route) {
                            StepTwoEstablishment(
                                onNavigate = {
                                    navController.navigate(AppDestination.StepThreeSignUpEstablishment.route)
                                }
                            )
                        }
                        composable(AppDestination.StepThreeSignUpEstablishment.route) {
                            val vm by inject<SignUpViewModel>()
                            StepThreeEstablishment(
                                onNavigate = {
                                    navController.navigate(AppDestination.StepFourSignUpEstablishment.route)
                                },
                                vm = vm
                            )
                        }
                        composable(AppDestination.StepFourSignUpEstablishment.route) {
                            StepFourEstablishment(
                                onNavigate = {
                                    navController.navigate(AppDestination.ProfileCustomer.route)
                                }
                            )
                        }
                        composable(AppDestination.MenuEstablishment.route) {
                            val vm by inject<MenuEstablishmentViewModel>()
                            MenuEstablishment(
                                vm = vm
                            )
                        }
                    }
                }
            }
        }
        startKoin {
            androidContext(this@MainActivity)
            modules(appModule)
        }
    }
}

@Composable
fun MainApp(
    content: @Composable () -> Unit
) {
    Box() {
        content()
    }
}

//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MainApp()
//}
