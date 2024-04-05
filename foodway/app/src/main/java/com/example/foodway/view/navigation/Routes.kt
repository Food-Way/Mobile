//package com.example.foodway.view.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavController
//import com.example.foodway.view.signUp.establishment.StepOneActivity
//
//object Routes {
//    object StepOne : Route {
//        override val name = "StepOne"
//        override val screen = @Composable { navController: NavController ->
//            StepOneActivity(navController = navController))
//        }
//    }
//
//    object StepTwo : Route {
//        override val name = "StepTwo"
//        override val screen = @Composable { navController: NavController ->
//            StepOneActivity(navController = navController)
//        }
//    }
//
//    object StepThree : Route {
//        override val name = "StepThree"
//        override val screen = @Composable { StepThreeActivity() }
//    }
//
//    object StepFour : Route {
//        override val name = "StepThree"
//        override val screen = @Composable { StepFourActivity() }
//    }
//}