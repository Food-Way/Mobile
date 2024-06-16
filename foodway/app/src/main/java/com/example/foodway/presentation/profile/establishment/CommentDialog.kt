package com.example.foodway.presentation.profile.establishment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.domain.model.ETypeUser
import com.example.foodway.domain.profile.establishment.model.ETypeRate
import com.example.foodway.domain.profile.establishment.model.PostComment
import com.example.foodway.domain.profile.establishment.model.Rate
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.InputGeneric
import com.example.foodway.presentation.components.RatingBar
import com.example.foodway.utils.Destination
import com.example.foodway.utils.PreferencesManager
import com.example.foodway.utils.ProfileId
import java.util.UUID

@Composable
fun CommentDialog(
    name: String,
    culinary: String,
    idEstablishment: UUID,
    vm: ProfileEstablishmentViewModel,
    sharedPreferences: PreferencesManager,
    onPostCommentSuccess: (Destination, ProfileId) -> Unit,
    onDismissRequest: () -> Unit,
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Column {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = culinary,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
            RatingBar(
                rating = avg,
                stars = 1,
                onRatingChanged = {
                },
                starsColor = Color.Yellow,
                editable = true
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RatingBar(
                modifier = Modifier
                    .width(200.dp),
                rating = ratingEnvironment,
                stars = 5,
                onRatingChanged = {
                    ratingEnvironment = it
                },
                starsColor = Color.Yellow,
                editable = true,
                viewValue = false,
                sizeStar = 25
            )

            Text(
                text = "Ambiente",
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RatingBar(
                modifier = Modifier
                    .width(200.dp),
                rating = ratingFood,
                stars = 5,
                onRatingChanged = {
                    ratingFood = it
                },
                starsColor = Color.Yellow,
                editable = true,
                viewValue = false,
                sizeStar = 25
            )

            Text(
                text = "Comida",
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RatingBar(
                modifier = Modifier
                    .width(200.dp),
                rating = ratingService,
                stars = 5,
                onRatingChanged = {
                    ratingService = it
                },
                starsColor = Color.Yellow,
                editable = true,
                viewValue = false,
                sizeStar = 25
            )

            Text(
                text = "Atendimento",
                fontSize = 12.sp
            )
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
                    token = sharedPreferences.getSavedData("token", ""),
                    postComment = PostComment(
                        idCustomer = UUID.fromString(sharedPreferences.getSavedData("id", "")).toString(),
                        idEstablishment = idEstablishment.toString(),
                        comment = comment,
                        userPhoto = sharedPreferences.getSavedData("photo", ""),
                        userName = sharedPreferences.getSavedData("name", ""),
                        typeUser = ETypeUser.CLIENT.name,
                        images = listOf()
                    ),
                    rates = listOf(
                        Rate(name = ETypeRate.FOOD.name, ratePoint = ratingFood),
                        Rate(name = ETypeRate.AMBIENT.name, ratePoint = ratingEnvironment),
                        Rate(name = ETypeRate.SERVICE.name, ratePoint = ratingService),
                    ),
                    onPostCommentSuccess = onPostCommentSuccess
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