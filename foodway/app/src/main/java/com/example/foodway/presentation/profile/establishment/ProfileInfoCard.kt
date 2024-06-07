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
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
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

        OutlinedCard(
            modifier = Modifier
                .graphicsLayer {
                    shadowElevation = 8.dp.toPx()
                    shape = RoundedCornerShape(16.dp)
                    clip = true
                    alpha = 1f
                }
                .blur(radius = 50.dp)
                .width(240.dp)
                .zIndex(1f)
                .height(220.dp)
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
                    fontSize = 16.sp
                )
                Text(
                    text = "Culinária $culinary",
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp
                )
                RatingBar(
                    modifier = Modifier
                        .size(20.dp),
                    rating = rate,
                    onRatingChanged = {},
                    starsColor = Color.Yellow,
                    editable = false
                )
                Text(
                    text = description,
                )
                Row(
                    horizontalArrangement = Arrangement.Start
                ) {
                    CulinaryCard(
                        culinary = culinary
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
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
                    ButtonGeneric(
                        text = "Cardápio",
                        textSize = 10,
                        modifier = Modifier
                            .width(105.dp)
                            .height(30.dp),
                        isPrimary = true,
                        onClick = {}
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

//@Preview(showBackground = true)
//@Composable
//fun ProfileInfoCardPreview() {
//    ProfileInfoCard(modifier = Modifier)
//}