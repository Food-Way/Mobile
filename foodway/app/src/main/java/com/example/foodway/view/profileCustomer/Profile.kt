package com.example.foodway.view.profileCustomer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R

@Composable
fun Profile() {
    var levelNum = 999;
    Row(
        modifier = Modifier.width(145.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.height(75.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.level, levelNum)
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
                    progress = 0.5f,
                    modifier = Modifier
                        .width(36.dp)
                        .height(6.dp),
                    color = Color.Green,
                    trackColor = colorResource(id = R.color.ligth_gray),
                    strokeCap = StrokeCap.Round,
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.goku),
            contentDescription = stringResource(id = R.string.image_profile),
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
                .padding(0.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    Profile()
}