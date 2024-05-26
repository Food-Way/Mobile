package com.example.foodway.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.foodway.R
import com.example.foodway.di.appModule
import com.example.foodway.presentation.components.NavBarComponent
import com.example.foodway.presentation.edit.customer.EditCustomerProfile
import com.example.foodway.presentation.establishmentMenu.MenuEstablishment
import com.example.foodway.presentation.navigation.AppDestination
import com.example.foodway.presentation.profile.customer.ProfileCustomer
import com.example.foodway.presentation.profile.establishment.ProfileEstablishment
import com.example.foodway.presentation.searchUser.SearchUser
import com.example.foodway.presentation.signIn.SignIn
import com.example.foodway.presentation.signIn.SignInViewModel
import com.example.foodway.presentation.signUp.SignUpViewModel
import com.example.foodway.presentation.signUp.customer.SignUpCustomer
import com.example.foodway.presentation.signUp.customer.StepOneCustomer
import com.example.foodway.presentation.signUp.customer.StepThreeCustomer
import com.example.foodway.presentation.signUp.customer.StepTwoCustomer
import com.example.foodway.presentation.signUp.establishment.StepFourEstablishment
import com.example.foodway.presentation.signUp.establishment.StepOneEstablishment
import com.example.foodway.presentation.signUp.establishment.StepThreeEstablishment
import com.example.foodway.presentation.signUp.establishment.StepTwoEstablishment
import com.example.foodway.presentation.ui.theme.FoodwayTheme
import com.example.foodway.presentation.welcome.Welcome
import com.example.foodway.presentation.establishmentMenu.MenuEstablishmentViewModel
import com.example.foodway.presentation.profile.customer.ProfileCustomerViewModel
import com.example.foodway.presentation.profile.establishment.ProfileEstablishmentViewModel
import com.example.foodway.presentation.searchUser.SearchUserViewModel
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.util.UUID


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val backStackState by navController.currentBackStackEntryAsState()
            val currentDestination = backStackState?.destination
            FoodwayTheme {
//                val showBottomAppBar = currentDestination?.let { destination ->
//                    bottomAppBarItems.find {
//                        it.destination.route == destination.route
//                    }
//                } != null
                MainApp(
                    nav = currentDestination,
                    onNavigate = { route ->
                        navController.navigate(route)
                    },
                    content = {
                        NavHost(
                            navController = navController,
                            startDestination = AppDestination.Welcome.route
                        ) {
                            composable(AppDestination.Welcome.route) {
                                Welcome(
                                    onNavigate = {
                                        navController.navigate(AppDestination.SignIn.route)
                                    },
                                )
                            }
                            composable("${AppDestination.ProfileCustomer.route}/{idCustomer}") {
                                val id = UUID.fromString(it.arguments?.getString("idCustomer"))
                                val vm by inject<ProfileCustomerViewModel>()
                                ProfileCustomer(
                                    vm = vm,
                                    idCustomer = id,
                                    onNavigate = { navController.navigate(AppDestination.ProfileCustomer.route) }
                                )
                            }
                            composable("${AppDestination.ProfileEstablishment.route}/{idEstablishment}") {
                                val id = UUID.fromString(it.arguments?.getString("idEstablishment"))
                                val vm by inject<ProfileEstablishmentViewModel>()
                                ProfileEstablishment(
                                    vm = vm,
                                    idEstablishment = id
                                )
                            }
                            composable(AppDestination.SignUpCustomer.route) {
                                val vm by inject<SignUpViewModel>()
                                SignUpCustomer(
                                    vm = vm,
                                    onNavigateSuccessSignUp = {
                                        navController.navigate(AppDestination.SignIn.route)
                                    }
                                )
                            }
                            composable(AppDestination.StepOneSignUpCustomer.route) {
                                val vm by inject<SignUpViewModel>()
                                StepOneCustomer(
                                    onStepComplete = {
                                        navController.navigate(AppDestination.StepTwoSignUpCustomer.route)
                                    },
                                    vm = vm,
                                    modifier = Modifier,
                                )
                            }
                            composable(AppDestination.StepTwoSignUpCustomer.route) {
                                val vm by inject<SignUpViewModel>()
                                StepTwoCustomer(
                                    onStepComplete = {
                                        navController.navigate(AppDestination.StepThreeSignUpCustomer.route)
                                    },
                                    vm = vm,
                                    modifier = Modifier,
                                    onGoBack = {}
                                )
                            }
                            composable(AppDestination.StepThreeSignUpCustomer.route) {
                                val vm by inject<SignUpViewModel>()
                                StepThreeCustomer(
                                    vm = vm,
                                    modifier = Modifier,
                                    onSignUpComplete = {},
                                    onGoBack = {}
                                )
                            }
                            composable(AppDestination.StepOneSignUpEstablishment.route) {
                                val vm by inject<SignUpViewModel>()
                                StepOneEstablishment(
                                    onStepComplete = {
                                        navController.navigate(AppDestination.StepTwoSignUpEstablishment.route)
                                    },
                                    vm = vm,
                                    modifier = Modifier
                                )
                            }
                            composable(AppDestination.StepTwoSignUpEstablishment.route) {
                                val vm by inject<SignUpViewModel>()
                                StepTwoEstablishment(
                                    onStepComplete = {
                                        navController.navigate(AppDestination.StepThreeSignUpEstablishment.route)
                                    },
                                    vm = vm,
                                    modifier = Modifier
                                )
                            }
                            composable(AppDestination.StepThreeSignUpEstablishment.route) {
                                val vm by inject<SignUpViewModel>()
                                StepThreeEstablishment(
                                    onStepComplete = {
                                        navController.navigate(AppDestination.StepFourSignUpEstablishment.route)
                                    },
                                    vm = vm,
                                    modifier = Modifier
                                )
                            }
                            composable(AppDestination.StepFourSignUpEstablishment.route) {
                                val vm by inject<SignUpViewModel>()
                                StepFourEstablishment(
                                    onSignUpComplete = {
                                        navController.navigate(AppDestination.ProfileCustomer.route)
                                    },
                                    vm = vm,
                                    modifier = Modifier
                                )
                            }
                            composable(AppDestination.MenuEstablishment.route) {
                                val vm by inject<MenuEstablishmentViewModel>()
                                MenuEstablishment(
                                    vm = vm
                                )
                            }
                            composable(AppDestination.SignIn.route) {
                                val vm by inject<SignInViewModel>()
                                SignIn(
                                    vm = vm,
                                    onNavigate = {
                                        navController.navigate(AppDestination.StepOneSignUpCustomer.route)
                                    },
                                    onNavigateSuccessSignInTo = { route, idProfile ->
                                        navController.navigate("${route}/$idProfile")
                                    },
                                )
                            }
                            composable(AppDestination.SearchUser.route) {
                                val vm by inject<SearchUserViewModel>()
                                SearchUser(
                                    vm = vm,
                                    onNavigate = {
                                        navController.navigate(AppDestination.SearchUser.route)
                                    }
                                )
                            }
                            composable(AppDestination.EditProfileCustomer.route) {
                                EditCustomerProfile()
                            }
                        }
                    })
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
    nav: NavDestination?,
    content: @Composable () -> Unit,
    onNavigate: (String) -> Unit
) {
    val items = listOf(
        R.drawable.profile_icon_gray,
        R.drawable.search_icon_black,
        R.drawable.config_icon_gray
    )

    Scaffold(
        drawerElevation = 0.dp,
        bottomBar = {
            val currentRoute = nav
            if (
                currentRoute?.route != AppDestination.Welcome.route &&
                currentRoute?.route != AppDestination.SignIn.route &&
                currentRoute?.route != AppDestination.SignUpCustomer.route
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    NavBarComponent(
                        items = items,
                        onItemSelected = onNavigate
                    )
                }
            }

//            else {
//                Text(text = "${currentRoute?.route}")
//            }
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
        ) {
            content()
        }
    }
}

//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MainApp()
//}