package com.example.foodway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.signUp.establishment.StepFourActivity
import com.example.foodway.view.signUp.establishment.StepOneActivity
import com.example.foodway.view.signUp.establishment.StepThreeActivity
import com.example.foodway.view.signUp.establishment.StepTwoActivity
import com.example.foodway.viewModel.SignUpViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    FoodwayTheme {
        NavHost(
            navController = navController,
            startDestination = "StepOne"
        ) {
            composable("StepOne"){ StepOneActivity(navController = navController)}
            composable("StepTwo"){ StepTwoActivity(navController = navController)}
            composable("StepThree"){ StepThreeActivity(navController = navController, vm = SignUpViewModel())}
            composable("StepFour"){ StepFourActivity(navController = navController)}
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainApp()
}
