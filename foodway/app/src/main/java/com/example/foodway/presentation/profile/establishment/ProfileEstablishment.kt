package com.example.foodway.presentation.profile.establishment

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.example.foodway.domain.profile.establishment.model.ProfileEstablishment
import com.example.foodway.presentation.MainScreenState
import java.util.UUID

@Composable
fun ProfileEstablishment(
    vm: ProfileEstablishmentViewModel,
    idEstablishment: UUID,
) {
    val state by vm.state.observeAsState()

    val showModal by vm.modalState.observeAsState()

    if (showModal == true) {
        Dialog(
            onDismissRequest = { vm.toggleModal(showModal = false) },
            content = {
                CommentDialog { vm.toggleModal(showModal = false) }
            }
        )
    }

    when (state) {
        is MainScreenState.Loading -> {
            Log.d("loading", "loading state")
            LoadingBar(
                loadingText = "Carregando Perfil..."
            )
            vm.getEstablishmentProfile(idEstablishment = idEstablishment)
        }

        is MainScreenState.Error, null -> {
            val errorMessage = (state as MainScreenState.Error).message
            Log.d("Error", "Error state")
            ErrorView(message = errorMessage) {
                vm.getEstablishmentProfile(idEstablishment = UUID.fromString("004cfdcd-4799-4224-8723-8015f8f85b44"))
            }
        }

        is MainScreenState.Success<*> -> {
            val profile = (state as MainScreenState.Success<ProfileEstablishment>).data
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
//                    ProfileInfoCard(
//                        modifier = Modifier
//                            .padding(innerPadding),
//                        name = profile.establishmentName,
//                        headerImage = profile.profileHeaderImg,
//                        culinary = profile.culinary,
//                        rate = profile.rate,
//                        description = "teste",
//                        description = profile.description,
//                        qtdComments = profile.qtdComments,
//                        qtdUpvotes = profile.qtdUpvotes
//                    )
//                    CommentList(
//                        profile.comments
//                    )
                    CommentBoxHandler(
                        showCommentDialog = {
                            vm.toggleModal()
                        }
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ProfileEstablishmentPreview() {
//    ProfileEstablishment(
//        )
//    )
//}