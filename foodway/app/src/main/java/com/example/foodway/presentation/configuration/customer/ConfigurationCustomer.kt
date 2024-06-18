package com.example.foodway.presentation.configuration.customer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.presentation.ui.theme.FoodwayTheme

@Composable
fun ConfigurationCustomer(
    onNavigateEditProfile: () -> Unit,
    onNavigateEditAccount: () -> Unit,
    onLogout: () -> Unit,
) {
    FoodwayTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .width(300.dp)
                        .padding(50.dp, 50.dp)
                ) {
                    Text(
                        text = "Configurações",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .height(350.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier
                                .height(300.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(50.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(colorResource(id = R.color.black))
                                    .padding(10.dp)
                                    .clickable {
                                        onNavigateEditProfile()
                                    }
                            ) {
                                Text(
                                    text = stringResource(id = R.string.edit_perfil),
                                    color = colorResource(id = R.color.white),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(50.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(colorResource(id = R.color.black))
                                    .padding(10.dp)
                                    .clickable {
                                        onNavigateEditAccount()
                                    }
                            ) {
                                Text(
                                    text = stringResource(id = R.string.edit_account),
                                    color = colorResource(id = R.color.white),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(50.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(colorResource(id = R.color.red))
                                    .padding(10.dp)
                                    .clickable {
                                        onLogout()
                                    }
                            ) {
                                Text(
                                    text = stringResource(id = R.string.logout),
                                    color = colorResource(id = R.color.white),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Text(
                            text = "Foodway App",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}