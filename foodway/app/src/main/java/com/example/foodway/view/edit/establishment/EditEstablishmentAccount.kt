package com.example.foodway.view.edit.establishment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.model.EstablishmentInputManager.personalEstablishmentInputInfos
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.InputGeneric
import com.example.foodway.view.components.NoBorderScreen

@Composable
fun EditEstablishmentAccount() {

    FoodwayTheme {
        NoBorderScreen {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Text(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Left,
                            text = stringResource(id = R.string.edit_account)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.edit_icon),
                            contentDescription = stringResource(id = R.string.image_profile_desc),
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                                .padding(start = 8.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                    Text(
                        fontSize = 16.sp,
                        text = stringResource(id = R.string.adjust)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.goku),
                    contentDescription = stringResource(id = R.string.image_profile_desc),
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .padding(0.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(20.dp, 21.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                LazyColumn {
                    items(personalEstablishmentInputInfos.size) { item ->
                        InputGeneric(
                            inputLabel = personalEstablishmentInputInfos[item].inputLabel,
                            icon = personalEstablishmentInputInfos[item].icon,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = personalEstablishmentInputInfos[item].type
                            )
                        )
                    }
                }
                ButtonGeneric(
                    text = stringResource(id = R.string.save_button),
                    modifier = Modifier
                        .width(250.dp)
                        .height(45.dp),
                    isPrimary = true
                ) {}
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EditAccountEstablishmentPreview() {
    EditEstablishmentAccount()
}