package com.example.foodway.presentation.signUp.establishment

import CategoryCard
import ErrorView
import LoadingBar
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.domain.model.Culinary
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.CardGrid
import com.example.foodway.presentation.components.ScreenBorder
import com.example.foodway.presentation.signUp.SignUpViewModel

@Composable
fun StepThreeEstablishment(
    modifier: Modifier,
    onStepComplete: () -> Unit = {},
    onGoBack: () -> Unit = {},
    vm: SignUpViewModel
) {
    val state by vm.state.observeAsState()
    ScreenBorder {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.8f)
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

            }

            Spacer(modifier = Modifier.height(37.dp))

            ButtonGeneric(
                text = stringResource(id = R.string.next),
                textSize = 18,
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