package com.example.foodway.presentation.profile.establishment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.domain.model.Comment
import com.example.foodway.domain.model.CommentChild
import com.example.foodway.domain.model.UserType
import com.example.foodway.domain.profile.establishment.model.PostComment
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.InputGeneric
import com.example.foodway.presentation.components.RatingBar
import com.example.foodway.utils.Destination
import com.example.foodway.utils.PreferencesManager
import com.example.foodway.utils.ProfileId
import java.util.UUID

@Composable
fun CommentReplyDialog(
    commentSelected: Comment?,
    idEstablishment: UUID,
    vm: ProfileEstablishmentViewModel,
    commentChild: List<CommentChild>,
    sharedPreferences: PreferencesManager,
    onPostCommentSuccess: (Destination, ProfileId) -> Unit,
    onUpvoteSuccess: (Destination, ProfileId) -> Unit,
    showCommentDialog: () -> Unit
) {
    var ratingEnvironment by remember {
        mutableDoubleStateOf(0.0)
    }

    var ratingFood by remember {
        mutableDoubleStateOf(0.0)
    }

    var ratingService by remember {
        mutableDoubleStateOf(0.0)
    }

    var comment by remember {
        mutableStateOf("")
    }

    val avg by remember {
        derivedStateOf { ((ratingEnvironment + ratingFood + ratingService) / 3) }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        if (commentSelected != null) {
            CommentItem(
                width = 300.dp,
                height = 180.dp,
                isChild = false,
                idComment = commentSelected.idPost,
                photo = commentSelected.userPhoto,
                comment = commentSelected.comment,
                rate = commentSelected.generalRate,
                qtdUpvotes = commentSelected.upvotes,
                commentChild = commentChild,
                idEstablishment = idEstablishment,
                vm = vm,
                sharedPreferences = sharedPreferences,
                onUpvoteSuccess = onUpvoteSuccess,
                showCommentDialog = showCommentDialog
            )
        }

        if (commentChild.isNotEmpty()) {
            LazyColumn(
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                items(commentChild) { commentChild ->
                    Row {
                        Divider(
                            modifier = Modifier
                                .height(180.dp) // A linha preencherá toda a altura disponível
                                .width(2.dp), // Defina a largura da linha
                            color = colorResource(id = R.color.light_black) // Defina a cor da linha
                        )
                        CommentItem(
                            width = 250.dp,
                            height = 180.dp,
                            isChild = true,
                            idComment = commentChild.idPost,
                            photo = commentChild.userPhoto,
                            comment = commentChild.comment,
                            rate = 0.0,
                            qtdUpvotes = commentChild.upvotes,
                            commentChild = emptyList(),
                            idEstablishment = idEstablishment,
                            vm = vm,
                            sharedPreferences = sharedPreferences,
                            onUpvoteSuccess = onUpvoteSuccess,
                            showCommentDialog = showCommentDialog
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        InputGeneric(
            modifier = Modifier
                .width(500.dp),
            inputLabel = R.string.comment_modal_initial,
            visualTransformation = VisualTransformation.None,
            labelState = comment,
            onValueChange = {
                comment = it
            }
        )

        Spacer(modifier = Modifier.height(36.dp))

        ButtonGeneric(
            text = "Enviar",
            textSize = 18,
            modifier = Modifier
                .width(400.dp)
                .height(40.dp),
            isPrimary = true,
            onClick = {
                vm.postComment(
                    postComment = PostComment(
                        idCustomer = UUID.fromString(sharedPreferences.getSavedData("id", "")).toString(),
                        idEstablishment = idEstablishment.toString(),
                        comment = comment,
                        userPhoto = sharedPreferences.getSavedData("photo", ""),
                        userName = sharedPreferences.getSavedData("name", ""),
                        typeUser = UserType.CLIENT.name,
                        images = listOf()
                    ),
                    onPostCommentSuccess = onPostCommentSuccess,
                    token = sharedPreferences.getSavedData("token", "")
                )
            }
        )
    }
}


//@Preview(showBackground = true)
//@Composable
//fun CommentDialogPreview() {
//    CommentDialog() {}
//}