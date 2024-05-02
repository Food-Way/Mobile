package com.example.foodway.view.profileEstablishment

import ErrorView
import LoadingBar
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.foodway.model.ProfileEstablishment
import com.example.foodway.view.components.Dialog
import com.example.foodway.viewModel.MainScreenState
import com.example.foodway.viewModel.ProfileEstablishmentViewModel
import java.util.UUID

//class ProfileEstablishmentActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            FoodwayTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    ProfileEstablishment()
//                }
//            }
//        }
//    }
//}

@Composable
fun ProfileEstablishment(
    vm: ProfileEstablishmentViewModel
) {
    val state by vm.state.observeAsState()

    var showModal by remember {
        mutableStateOf(false)
    }

    if (showModal) {
        Dialog(
            onDismissRequest = {
                showModal = false
            },
            content = { CommentDialog() }
        )
    }

    when (state) {
        is MainScreenState.Loading -> {
            Log.d("loading", "loading state")
            LoadingBar(
                loadingText = "Carregando Perfil..."
            )
            vm.getEstablishmentProfile(idEstablishment = UUID.fromString("004cfdcd-4799-4224-8723-8015f8f85b44"))
        }

        is MainScreenState.Error, null -> {
            val errorMessage = (state as MainScreenState.Error).message
            Log.d("Error", "Error state")
            ErrorView(message = errorMessage) {
                vm.getEstablishmentProfile(idEstablishment = UUID.fromString("004cfdcd-4799-4224-8723-8015f8f85b44"))
            }
        }

        is MainScreenState.SuccessSingle<*> -> {
            val profile = (state as MainScreenState.SuccessSingle<ProfileEstablishment>).data
            Log.d("Success", "Success state")

            Scaffold(
                bottomBar = {}
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    ProfileInfoCard(
                        modifier = Modifier
                            .padding(innerPadding),
                        name = profile.establishmentName,
                        headerImage = profile.profileHeaderImg,
                        culinary = profile.culinary,
                        rate = profile.rate,
                        description = "teste",
//                        description = profile.description,
                        qtdComments = profile.qtdComments,
                        qtdUpvotes = profile.qtdUpvotes
                    )
                    CommentList(
                        profile.comments
                    )
                    CommentBoxHandler(
                        showCommentDialog = {
                            showModal = true
                        }
                    )
                }
            }
        }

        else -> {
            Log.d("State", "Else State")
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ProfileEstablishmentPreview() {
//    ProfileEstablishment()
//}