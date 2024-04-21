package com.example.foodway.view.signUp.establishment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coroutine.ErrorView
import com.example.coroutine.LoadingBar
import com.example.foodway.R
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.ScreenBorder
import com.example.foodway.view.signUp.CategoryGrid
import com.example.foodway.viewModel.SignUpViewModel

class StepThreeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodwayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val vm = viewModel<SignUpViewModel>()
                    vm.getAllCulinaries()
                    StepThreeEstablishmentActivity(vm)
                }
            }
        }
    }
}

@Composable
fun StepThreeEstablishmentActivity(
//    onNavigateNextStep: () -> Unit = {},
    vm: SignUpViewModel
) {

    val isLoading by vm.isLoading.observeAsState()
    val isError by vm.isError.observeAsState()
    val isSuccess by vm.isSuccess.observeAsState()
    val errorMessage by vm.errorMessage.observeAsState()

    ScreenBorder {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp, 21.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.category_selection)
            )
            if (isLoading == true) {
                LoadingBar()
            } else if (isError == true) {
                ErrorView() {
                    vm.getAllCulinaries()
                }
            } else {
                isSuccess?.let { culinaryList ->
                    CategoryGrid(culinaries = culinaryList)
                }
            }

            ButtonGeneric(
                text = stringResource(id = R.string.next),
                width = 250.dp,
                height = 45.dp,
                isPrimary = false
            ) {
//                onNavigateNextStep()
            }
        }
    }
}


