package com.example.foodway.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.foodway.R

@Composable
fun InputGeneric(
    @StringRes
    inputLabel: Int,
    @DrawableRes
    icon: Int = 0,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation,
    labelState: String,
    onValueChange: (String) -> Unit
) {

    var mutableLabelState by remember { mutableStateOf("") }

    OutlinedTextField(
        value = labelState,
        onValueChange = onValueChange,
        label = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (icon != 0) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = stringResource(id = inputLabel)
                    )
                }
                Text(
                    text = stringResource(id = inputLabel),
                    modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)
                )
            }
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        colors = OutlinedTextFieldDefaults.colors(
            focusedLabelColor = colorResource(id = R.color.black),
            unfocusedLabelColor = colorResource(id = R.color.black),
        ),
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    )
}