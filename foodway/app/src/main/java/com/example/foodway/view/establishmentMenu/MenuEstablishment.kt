package com.example.foodway.view.establishmentMenu

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
import com.example.foodway.model.Product
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.CardGrid
import com.example.foodway.view.components.ScreenBorder
import com.example.foodway.viewModel.MainScreenState
import com.example.foodway.viewModel.MenuEstablishmentViewModel
import java.util.UUID

@Composable
fun MenuEstablishment(
    vm: MenuEstablishmentViewModel
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
                text = stringResource(id = R.string.menu_title)
            )

            Text(
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.establishment_name),
            )

            when (state) {
                is MainScreenState.Loading -> {
                    Log.d("loading", "loading state")
                    LoadingBar(
                        loadingText = stringResource(id = R.string.loading_products)
                    )
                    vm.getAllProducts(
                        idEstablishment = UUID.fromString("004cfdcd-4799-4224-8723-8015f8f85b44")
                    )
                }

                is MainScreenState.Error, null -> {
                    val errorMessage = (state as MainScreenState.Error).message
                    Log.d("Error", "Error state")
                    ErrorView(message = errorMessage) {
                        vm.getAllProducts(
                            idEstablishment = UUID.fromString("004cfdcd-4799-4224-8723-8015f8f85b44")
                        )
                    }
                }

                is MainScreenState.Success<*> -> {
                    val products = (state as MainScreenState.Success<Product>).data as List<Product>
                    Log.d("Success", "Success state")
                    CardGrid(products, buildItem = { product ->
                        ProductCard(product)
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
//                onNavigate()
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun MenuEstablishmentPreview() {
//    MenuEstablishment()
//}