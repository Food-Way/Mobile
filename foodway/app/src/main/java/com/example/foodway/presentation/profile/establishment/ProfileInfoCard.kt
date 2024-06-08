package com.example.foodway.presentation.profile.establishment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.foodway.R
import com.example.foodway.presentation.components.ButtonGeneric
import com.example.foodway.presentation.components.CoilImage
import com.example.foodway.presentation.components.Indicator
import com.example.foodway.presentation.components.RatingBar

@Composable
fun ProfileInfoCard(
    modifier: Modifier,
    name: String,
    headerImage: String,
    culinary: String,
    rate: Double,
    description: String,
    qtdComments: Int,
    qtdUpvotes: Int
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.background_image_establishment),
            contentDescription = "aaa"
        )

        Box(
            modifier = Modifier
                .background(Color.White.copy(alpha = 0.3f), RoundedCornerShape(20.dp))
                .blur(radius = 16.dp)
                .width(240.dp)
                .zIndex(1f)
                .height(220.dp)
                .border(1.dp, colorResource(id = R.color.gray), RoundedCornerShape(20.dp))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.white)
                )
                Text(
                    text = "Culinária $culinary",
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.white)
                )

                Spacer(modifier = Modifier.height(10.dp))

                RatingBar(
                    modifier = Modifier
                        .width(160.dp)
                        .size(20.dp),
                    rating = rate,
                    onRatingChanged = {},
                    starsColor = Color.Yellow,
                    textColor = colorResource(id = R.color.white),
                    editable = false,
                    sizeStar = 20
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .padding(10.dp, 5.dp),
                    text = description,
                    color = colorResource(id = R.color.white)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp, 0.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
//                    CulinaryCard(
//                        culinary = culinary
//                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ButtonGeneric(
                        text = "Cardápio",
                        textSize = 10,
                        modifier = Modifier
                            .width(105.dp)
                            .height(30.dp),
                        isPrimary = true,
                        onClick = {}
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .width(80.dp)
                            .background(
                                colorResource(id = R.color.white),
                                RoundedCornerShape(10.dp)
                            )
                    ) {
                        Indicator(
                            quantity = qtdComments,
                            hasQuantity = true,
                            icon = R.drawable.comment,
                            description = R.string.comments,
                            size = 20.dp,
                            fontSize = 10,
                            widthIndicator = 30.dp
                        )
                        Indicator(
                            quantity = qtdUpvotes,
                            hasQuantity = true,
                            icon = R.drawable.upvote,
                            description = R.string.upvotes,
                            size = 20.dp,
                            fontSize = 10,
                            widthIndicator = 30.dp
                        )
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ProfileInfoCardPreview() {
//    ProfileInfoCard(modifier = Modifier)
//}