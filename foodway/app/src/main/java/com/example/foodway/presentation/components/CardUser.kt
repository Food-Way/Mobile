package com.example.foodway.presentation.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.domain.model.ETypeUser
import com.example.foodway.presentation.navigation.AppDestination
import com.example.foodway.utils.Destination
import com.example.foodway.utils.ProfileId
import java.util.UUID

@Composable
fun CardUser(
    id: UUID,
    name: String,
    photo: String,
    rate: Double,
    typeUser: ETypeUser,
    onNavigateToProfile : (Destination, ProfileId) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .width(110.dp)
            .height(140.dp)
            .border(1.dp, colorResource(id = R.color.light_gray), RoundedCornerShape(10.dp))
            .clickable {
                onNavigateToProfile(
                    when (typeUser) {
                        ETypeUser.CLIENT -> AppDestination.ProfileCustomer.route
                        ETypeUser.ESTABLISHMENT -> AppDestination.ProfileEstablishment.route
                    },
                    id.toString()
                )
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(3.dp)
        ) {
            if (name.length > 10) {
                MovingText(name)
            } else {
                Text(
                    text = name,
                    fontSize = 12.sp
                )
            }
            ProfileImage(photo = photo, size = 80.dp)
            Row {
                RateUser(rate = rate)
            }
        }
    }
}
@Composable
fun MovingText(contentText: String) {
    val infiniteTransition = rememberInfiniteTransition()

    val animatedOffsetX by infiniteTransition.animateFloat(
        initialValue = 100f,
        targetValue = -100f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 4000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(20.dp)
    ) {
        Text(
            softWrap = false,
            maxLines = 1,
            text = contentText,
            fontSize = 12.sp,
            modifier = Modifier.offset(x = animatedOffsetX.dp)
        )
    }
}
