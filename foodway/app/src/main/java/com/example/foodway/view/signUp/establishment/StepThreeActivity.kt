package com.example.foodway.view.signUp.establishment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavController
import com.example.coroutine.ErrorView
import com.example.coroutine.LoadingBar
import com.example.foodway.R
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.ScreenBorder
import com.example.foodway.view.signUp.CategoryGrid
import com.example.foodway.viewModel.CulinarySelectViewModel

@Composable
fun StepThreeActivity(navController: NavController, vm: CulinarySelectViewModel) {

    val isLoading by vm.isLoading.observeAsState()
    val isError by vm.isError.observeAsState()
    val isSuccess by vm.isSuccess.observeAsState()
    val errorMessage by vm.errorMessage.observeAsState()

    FoodwayTheme {
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
                    ErrorView(message = errorMessage!!) {
                        vm.getAllMusicas()
                    }
                } else {
                    val culinary = isSuccess
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(isSuccess!!) {
                            if (culinary != null) {
                                CategoryGrid(culinaries = culinary)
                            }
                        }
                    }
                }
                ButtonGeneric(
                    text = stringResource(id = R.string.next),
                    width = 250.dp,
                    height = 45.dp,
                    isPrimary = false
                ) {
                    navController.navigate("StepFour")
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun StepThreeActivityPreview() {
//    StepThreeActivity()
//}
