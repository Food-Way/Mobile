package com.example.foodway.view.edit.customer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodway.R
import com.example.foodway.model.CustomerInputManager.personalCustomerInputInfos
import com.example.foodway.view.components.ButtonGeneric
import com.example.foodway.view.components.InputGeneric


@Composable
fun EditCustomerAccount() {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(25.dp)
            .fillMaxWidth()
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.edit_account),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp,
                )

                Text(
                    text = stringResource(id = R.string.adjust_necessary),
                    fontSize = 15.sp,
                )
            }

            Image(
                painter = painterResource(id = R.drawable.foodway_logo),
                contentDescription = stringResource(id = R.string.logo),
                modifier = Modifier
                    .width(95.dp)
                    .height(98.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(personalCustomerInputInfos.size) { item ->
                InputGeneric(
                    inputLabel = personalCustomerInputInfos[item].inputLabel,
                    icon = personalCustomerInputInfos[item].icon,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = personalCustomerInputInfos[item].type
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        ButtonGeneric(
            text = stringResource(id = R.string.save),
            modifier = Modifier
                .width(270.dp)
                .height(43.dp),
            isPrimary = true
        ) {}

        Spacer(modifier = Modifier.height(20.dp))


    }
}

@Preview(showBackground = true)
@Composable
fun EditAccountPreview() {
    EditCustomerAccount()
}
