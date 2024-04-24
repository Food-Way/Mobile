package com.example.foodway.view.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodway.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.InputGeneric

@Composable
fun Login() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(650.dp)
                .padding(16.dp)
                .border(2.dp, Color.LightGray, RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.foodway_logo),
                    contentDescription = stringResource(id = R.string.logo),
                    modifier = Modifier
                        .width(95.dp)
                        .height(98.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    stringResource(id = R.string.welcome_login),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                InputGeneric(
                    inputLabel = stringResource(id = R.string.email),
                    icon = R.drawable.email_icon
                )

                Spacer(modifier = Modifier.height(15.dp))

                InputGeneric(
                    inputLabel = stringResource(id = R.string.password),
                    icon = R.drawable.lock_icon
                )

                Spacer(modifier = Modifier.height(40.dp))

                ButtonGeneric(
                    text = stringResource(id = R.string.enter),
                    width = 270.dp,
                    height = 43.dp,
                    isPrimary = true
                ) {

                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(id = R.string.forgot_your_password),
                    fontSize = 15.sp,
                    modifier = Modifier.clickable {

                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .border(1.dp, Color.LightGray)
                        .width(270.dp)
                        .height(1.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(id = R.string.has_account),
                    fontSize = 15.sp,
                )
                Spacer(modifier = Modifier.height(20.dp))
                ButtonGeneric(
                    text = stringResource(id = R.string.register),
                    width = 150.dp,
                    height = 43.dp,
                    isPrimary = false
                ) {

                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Login()
}