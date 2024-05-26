package com.example.foodway.presentation.profile.customer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
@Composable
fun Profile(
    photo: String,
    level: Int,
    xp: Double
) {
    Row(
        modifier = Modifier.width(145.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.height(75.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.level, level)
            )
            Row(
                modifier = Modifier.width(57.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = stringResource(id = R.string.experience_acronym),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                LinearProgressIndicator(
                    progress = xp.toFloat(),
                    modifier = Modifier
                        .width(36.dp)
                        .height(6.dp),
                    color = Color.Green,
                    trackColor = colorResource(id = R.color.light_gray),
                    strokeCap = StrokeCap.Round,
                )
            }
        }
        //ProfileImage(
         //   photo = photo,
         //   size = 75.dp
       // )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ProfilePreview() {
//    Profile()
//}