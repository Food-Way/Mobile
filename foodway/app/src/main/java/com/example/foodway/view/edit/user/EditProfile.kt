package com.example.foodway.view.edit.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.InputGeneric


@Composable
fun EditProfile() {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .fillMaxSize()

    ) {
        Column {
            Text(
                text = stringResource(id = R.string.edit_perfil_emoji),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
            )

            Text(
                text = stringResource(id = R.string.adjust_necessary),
                fontSize = 15.sp,
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.foodway_logo),
                contentDescription = stringResource(id = R.string.logo),
                modifier = Modifier
                    .width(95.dp)
                    .height(98.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))

            ButtonGeneric(
                text = stringResource(id = R.string.change_profile),
                width = 270.dp,
                height = 43.dp,
                isPrimary = false,
            ) {

            }

            Spacer(modifier = Modifier.height(30.dp))

            InputGeneric(
                inputLabel = stringResource(id = R.string.name),
                icon = R.drawable.person_icon
            )

            Spacer(modifier = Modifier.height(10.dp))

            InputGeneric(
                inputLabel = stringResource(id = R.string.bio),
                icon = R.drawable.stars
            )

            Spacer(modifier = Modifier.height(30.dp))

            ButtonGeneric(
                text = stringResource(id = R.string.save),
                width = 270.dp,
                height = 43.dp,
                isPrimary = true
            ) {

            }

            Spacer(modifier = Modifier.height(20.dp))

            ButtonGeneric(
                text = stringResource(id = R.string.edit_perfil),
                width = 270.dp,
                height = 43.dp,
                isPrimary = false
            ) {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditProfilePreview() {
    EditProfile()
}