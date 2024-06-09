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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.example.foodway.domain.profile.establishment.model.ProfileEstablishment
import com.example.foodway.presentation.MainScreenState
import com.example.foodway.utils.Destination
import com.example.foodway.utils.EstablishmentName
import com.example.foodway.utils.PreferencesManager
import com.example.foodway.utils.ProfileId
import java.util.UUID

@Composable
fun ProfileEstablishment(
    vm: ProfileEstablishmentViewModel,
    vm2: CommentViewModel,
    idEstablishment: UUID,
    sharedPreferences: PreferencesManager,
    onPostCommentSuccess: (Destination, ProfileId) -> Unit,
    onNavigateToMenu: (ProfileId, EstablishmentName) -> Unit,
    onUpvoteSuccess: (Destination, ProfileId) -> Unit
) {
    val state by vm.state.observeAsState()
    var establishmentName by remember { mutableStateOf("") }
    var culinary by remember { mutableStateOf("") }

    val showModal by vm.modalState.observeAsState()

    if (showModal == true) {
        Dialog(
            onDismissRequest = { vm.toggleModal(showModal = false) },
            content = {
                CommentDialog(
                    name = establishmentName,
                    culinary = culinary,
                    vm = vm,
                    idEstablishment = idEstablishment,
                    sharedPreferences = sharedPreferences,
                    onPostCommentSuccess = onPostCommentSuccess
                ) {
                    vm.toggleModal(showModal = false)
                }
            }
        )
    }

    when (state) {
        is MainScreenState.Loading -> {
            LoadingBar(
                loadingText = "Carregando Perfil..."
            )
            vm.getEstablishmentProfile(idEstablishment = idEstablishment)
        }

        is MainScreenState.Error, null -> {
            val errorMessage = (state as MainScreenState.Error).message
            Log.d("Error", "Error state$errorMessage")
            ErrorView(message = errorMessage) {
                vm.getEstablishmentProfile(idEstablishment = idEstablishment)
            }
        }

        is MainScreenState.Success<*> -> {
            val profile = (state as MainScreenState.Success<ProfileEstablishment>).data
            establishmentName = profile.establishmentName
            culinary = profile.culinary

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
                        idEstablishment = idEstablishment,
                        name = profile.establishmentName,
                        culinary = profile.culinary,
                        rate = profile.generalRate,
                        qtdComments = profile.qtdComments,
                        qtdUpvotes = profile.qtdUpvotes,
                        onNavigateToMenu = onNavigateToMenu
                    )
                    CommentList(
                        comments = profile.comments,
                        idEstablishment = idEstablishment,
                        sharedPreferences = sharedPreferences,
                        vm = vm,
                        onUpvoteSuccess = onUpvoteSuccess
                    )
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