package com.example.foodway.view.signUp.establishment

import CategoryCard
import ErrorView
import LoadingBar
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.foodway.R
import com.example.foodway.model.Culinary
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.CardGrid
import com.example.foodway.view.components.ScreenBorder
import com.example.foodway.viewModel.MainScreenState
import com.example.foodway.viewModel.SignUpViewModel

@Composable
fun StepThree(
    modifier: Modifier,
    onGoBack: () -> Unit = {},
    onStepComplete: () -> Unit = {},
    vm: SignUpViewModel
) {
    val state by vm.state.observeAsState()
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

            when (state) {
                is MainScreenState.Loading -> {
                    Log.d("loading", "loading state")
                    LoadingBar(
                        loadingText = "Carregando culinárias..."
                    )
                    vm.getAllCulinaries()
                }

                is MainScreenState.Error, null -> {
                    val errorMessage = (state as MainScreenState.Error).message
                    Log.d("Error", "Error state")
                    ErrorView(message = errorMessage) {
                        vm.getAllCulinaries()
                    }
                }

                is MainScreenState.Success<*> -> {
                    val culinaries = (state as MainScreenState.Success<Culinary>).data as List<Culinary>
                    Log.d("Success", "Success state")
                    CardGrid(culinaries, buildItem = { culinary ->
                        CategoryCard(culinary) { clickedCulinary ->
                            vm.toggleCulinary(clickedCulinary)
                        }
                    })
                }
            }

            ButtonGeneric(
                text = stringResource(id = R.string.next),
                modifier = Modifier
                    .width(250.dp)
                    .height(45.dp),
                isPrimary = false
            ) {
                onStepComplete()
            }
        }
    }
}