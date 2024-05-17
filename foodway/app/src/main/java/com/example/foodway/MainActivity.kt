package com.example.foodway

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.foodway.di.appModule
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.components.NavBarComponent
import com.example.foodway.view.edit.customer.EditCustomerProfile
import com.example.foodway.view.establishmentMenu.MenuEstablishment
import com.example.foodway.view.navigation.AppDestination
import com.example.foodway.view.profileCustomer.ProfileCustomer
import com.example.foodway.view.profileEstablishment.ProfileEstablishment
import com.example.foodway.view.searchUser.SearchUser
import com.example.foodway.view.signIn.SignIn
import com.example.foodway.view.signUp.customer.SignUpCustomer
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
import com.example.foodway.viewModel.SearchUserViewModel
import com.example.foodway.viewModel.SignInViewModel
import com.example.foodway.viewModel.SignUpViewModel
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
                                val sharedPreferences =
                                    getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                                val editor = sharedPreferences.edit()
                                editor.putString("customerId", id.toString())
                                editor.apply()
                                ProfileCustomer(
                                    vm = vm,
                                    idCustomer = id,
                                    onNavigate = { navController.navigate(AppDestination.ProfileCustomer.route) }
                                )
                            }
                            composable(AppDestination.ProfileEstablishment.route) {
                                val vm by inject<ProfileEstablishmentViewModel>()
                                ProfileEstablishment(
                                    vm = vm
                                )
                            }
                            composable(AppDestination.SignUpCustomer.route) {
                                val vm by inject<SignUpViewModel>()
                                SignUpCustomer(
                                    vm = vm,
                                    onNavigateSuccessSignIn = {
                                        navController.navigate(AppDestination.SignIn.route)
                                    }
                                )
                            }
                            composable(AppDestination.StepOneSignUpCustomer.route) {
                                val vm by inject<SignUpViewModel>()
                                StepOneCustomer(
                                    onNavigate = {
                                        navController.navigate(AppDestination.StepTwoSignUpCustomer.route)
                                    },
                                    vm = vm
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
                                val vm by inject<SignUpViewModel>()
                                StepThreeCustomer(
                                    vm = vm
                                )
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
                            composable(AppDestination.SignIn.route) {
                                val vm by inject<SignInViewModel>()
                                SignIn(
                                    vm = vm,
                                    onNavigate = {
                                        navController.navigate(AppDestination.StepOneSignUpCustomer.route)
                                    },
                                    onNavigateSuccessSignIn = { idCustomer ->
                                        navController.navigate("${AppDestination.ProfileCustomer.route}/$idCustomer")
                                    }
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
