package com.example.foodway.presentation.profile.establishment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.foodway.R
import com.example.foodway.domain.model.Comment
import com.example.foodway.domain.model.CommentChild
import com.example.foodway.domain.profile.establishment.model.PatchUpvote
import com.example.foodway.presentation.components.Indicator
import com.example.foodway.presentation.components.ProfileImage
import com.example.foodway.presentation.components.RatingBar
import com.example.foodway.utils.Destination
import com.example.foodway.utils.PreferencesManager
import com.example.foodway.utils.ProfileId
import java.util.UUID

fun generateRandomName(): String {
    val firstNames = listOf("Alice", "Bob", "Charlie", "Diana", "Edward", "Fiona", "George", "Hannah", "Irene", "Jack")
    val lastNames = listOf("Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Martinez", "Rodriguez")
    
    val randomFirstName = firstNames.random()
    val randomLastName = lastNames.random()
    return "$randomFirstName $randomLastName"
}

@Composable
fun CommentItem(
    idComment: UUID,
    userName: String = "",
    photo: String,
    comment: String,
    rate: Double,
    qtdUpvotes: Int,
    commentChild: List<CommentChild>,
    width: Dp,
    height: Dp,
    isChild: Boolean,
    idEstablishment: UUID,
    vm: ProfileEstablishmentViewModel,
    sharedPreferences: PreferencesManager,
    onUpvoteSuccess: (Destination, ProfileId) -> Unit,
    showCommentDialog: () -> Unit
) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white)
        ),
        border = BorderStroke(1.dp, colorResource(id = R.color.light_gray)),
        modifier = Modifier
            .size(width, height)
            .padding(10.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    ProfileImage(
                        photo = photo,
                        size = 35.dp,
                        type = "miniProfile"
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    if (!isChild) {
                        RatingBar(
                            modifier = Modifier
                                .width(120.dp),
                            rating = rate,
                            stars = 5,
                            onRatingChanged = {},
                            starsColor = Color.Yellow,
                            editable = false,
                            viewValue = false,
                            sizeStar = 20
                        )
                    } else {
                        Text(text = userName ?: "")
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(
                    bottom = 8.dp,
                    start = 8.dp,
                    end = 8.dp
                )
        ) {
            TextFlexible(comment = comment)
        }

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp)
        ) {
            Indicator(
                quantity = qtdUpvotes,
                hasQuantity = true,
                icon = R.drawable.upvote,
                description = R.string.upvotes,
                size = 20.dp,
                fontSize = 10,
                widthIndicator = 30.dp,
                onclick = {
                    vm.patchUpvote(
                        token = sharedPreferences.getSavedData("token", ""),
                        patchUpvote = PatchUpvote(
                            idCustomer = UUID.fromString(sharedPreferences.getSavedData("id", "")),
                            idComment = idComment,
                            idEstablishment = idEstablishment
                        ),
                        onUpvoteSuccess = onUpvoteSuccess,
                    )
                }
            )

            Spacer(modifier = Modifier.width(10.dp))

            Indicator(
                quantity = 0,
                hasQuantity = false,
                icon = R.drawable.comment,
                description = R.string.comments,
                size = 20.dp,
                fontSize = 10,
                widthIndicator = 30.dp,
                onclick = {
                    vm.setSelectedComment(
                        Comment(
                            idComment,
                            photo,
                            comment,
                            rate,
                            qtdUpvotes,
                            commentChild,
                        )
                    )
                    showCommentDialog()
                }
            )
        }
    }
}

@Composable
fun TextFlexible(comment: String) {
    if (comment.length > 20) {
        Box(
            modifier = Modifier
                .height(70.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = comment,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(8.dp)
            )
        }
    } else {
        Box(
            modifier = Modifier
                .height(70.dp),
        ) {
            Text(
                text = comment,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}