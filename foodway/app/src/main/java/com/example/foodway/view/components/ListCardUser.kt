package com.example.foodway.view.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R

@Composable
fun ListCardUser(
    photo: String,
    name: String,
    rateStar: Double,
    description: String,
    qtdComment: Int,
    qtdUpVotes: Int
) {
    var heartValue by remember { mutableStateOf(false) }
    var heartImg by remember { mutableStateOf(R.drawable.heart_empty) }

    Card(
        modifier = Modifier
            .width(300.dp)
            .padding(bottom = 10.dp)
            .border(2.dp, colorResource(id = R.color.light_gray), RoundedCornerShape(10.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(8.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (photo != null && photo != "") {
                Log.d("IMAGEM", photo)
                CoilImage(
                    photo = photo,
                    description = stringResource(id = R.string.image_establishment_desc),
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .padding(0.dp),
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(80.dp),
                    painter = painterResource(id = R.drawable.imgmc),
                    contentDescription = stringResource(id = R.string.estab_tab),
                    contentScale = ContentScale.Fit,
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column(
                modifier = Modifier
                    .padding(0.dp, 10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 0.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = name,
                        fontWeight = FontWeight.SemiBold
                    )
                    Row(
                        modifier = Modifier
                            .width(80.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Indicator(
                            quantity = qtdComment,
                            hasQuantity = true,
                            icon = R.drawable.comment,
                            description = R.string.comments,
                            size = 15.dp,
                            fontSize = 10,
                            widthIndicator = 35.dp
                        )
                        Indicator(
                            quantity = qtdUpVotes,
                            hasQuantity = true,
                            icon = R.drawable.upvote,
                            description = R.string.upvotes,
                            size =15.dp,
                            fontSize = 10,
                            widthIndicator = 35.dp
                        )
                    }
                }
                RatingBar(
                    rating = rateStar,
                    onRatingChanged = {},
                    starsColor = Color.Yellow,
                    editable = false,
                    viewValue = false
                )
                Row {
                    Text(
                        modifier = Modifier
                            .width(150.dp)
                            .padding(5.dp),
                        text = description,
                        fontSize = 9.sp,
                        lineHeight = 11.sp
                    )
                    Column(
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.End
                    ) {
                        Image(
                            modifier = Modifier
                                .clickable {
                                    if (heartValue) {
                                        heartImg = R.drawable.heart_empty
                                        heartValue = false
                                    } else {
                                        heartImg = R.drawable.heart_full
                                        heartValue = true
                                    }
                                },
                            alignment = Alignment.BottomEnd,
                            painter = painterResource(id = heartImg),
                            contentDescription = stringResource(id = R.string.estab_tab),
                        )
                    }
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun ListCardUserPreview() {
//    ListCardUser()
//}