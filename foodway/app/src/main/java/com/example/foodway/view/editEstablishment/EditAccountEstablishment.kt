package com.example.foodway.view.editEstablishment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.model.Input
import com.example.foodway.ui.theme.FoodwayTheme
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.InputGeneric
import com.example.foodway.view.components.NoBorderScreen
import com.example.foodway.view.components.ScreenBorder
import com.example.foodway.view.profileCustomer.Profile

@Composable
fun EditAccountEstablishment() {


    val inputList = listOf(
        Input(
            inputLabel = stringResource(id = R.string.fantasy_name),
            icon = R.drawable.person_icon
        ),
        Input(
            inputLabel = stringResource(id = R.string.responsible),
            icon = R.drawable.person_icon
        ),
        Input(
            inputLabel = stringResource(id = R.string.email),
            icon = R.drawable.person_icon
        ),
        Input(
            inputLabel = stringResource(id = R.string.password),
            icon = R.drawable.lock_icon
        ),
        Input(
            inputLabel = stringResource(id = R.string.conf_password),
            icon = R.drawable.lock_icon
        ),
    )

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
                    items(inputList.size) { item ->
                        InputGeneric(
                            inputLabel = inputList[item].inputLabel,
                            icon = inputList[item].icon
                        )
                    }
                }

                ButtonGeneric(
                    text = stringResource(id = R.string.save_button),
                    width = 250.dp,
                    height = 45.dp,
                    isPrimary = true
                ) {

                }
            }
        }
    }
}

//
@Preview(showBackground = true)
@Composable
fun EditAccountEstablishmentPreview() {
    EditAccountEstablishment()
}