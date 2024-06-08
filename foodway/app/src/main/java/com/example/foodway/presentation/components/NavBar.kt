package com.example.foodway.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodway.R
import com.example.foodway.domain.model.UserType
import com.example.foodway.presentation.navigation.AppDestination
import com.example.foodway.utils.PreferencesManager

@Composable
fun NavBarComponent(
    items: List<Int>,
    onItemSelected: (String) -> Unit,
    sharedPreferences: PreferencesManager,
) {
    var selectedIndex by remember { mutableStateOf(0) }
    val backgroundColor = Color.White
    val selectedItemTextColor = Color.Black
    val unselectedItemTextColor = Color.Gray
    val indicatorColor = Color.Blue
    val navBarHeight = 50.dp

    Surface(
        modifier = Modifier
            .width(300.dp)
            .padding(top = 8.dp)
            .height(navBarHeight)
            .border(2.dp, colorResource(id = R.color.light_gray), RoundedCornerShape(10.dp)),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            val idUser = sharedPreferences.getSavedData("id", "")
            val typeUser = sharedPreferences.getSavedData("typeUser", "")
            items.forEachIndexed { index, value ->
                val route = when (typeUser) {
                    UserType.ESTABLISHMENT.name -> {
                        when (index) {
                            0 -> "${AppDestination.ProfileEstablishment.route}/$idUser"
                            1 -> AppDestination.SearchUser.route
                            2 -> AppDestination.EditEstablishmentProfile.route
                            else -> ""
                        }
                    }
                    UserType.CLIENT.name -> {
                        when (index) {
                            0 -> "${AppDestination.ProfileCustomer.route}/$idUser"
                            1 -> AppDestination.SearchUser.route
                            2 -> AppDestination.EditCustomerProfile.route
                            else -> ""
                        }
                    }
                    else -> ""
                }

                NavBarItem(
                    icon = value,
                    isSelected = index == selectedIndex,
                    onSelected = {
                        selectedIndex = index
                        onItemSelected.invoke(route)
                    },
                    selectedIconColor = selectedItemTextColor,
                    unselectedIconColor = unselectedItemTextColor,
                    indicatorColor = indicatorColor
                )
            }
        }
    }
}

@Composable
fun NavBarItem(
    icon: Int,
    isSelected: Boolean,
    onSelected: () -> Unit,
    selectedIconColor: Color,
    unselectedIconColor: Color,
    indicatorColor: Color
) {
    val textColor = if (isSelected) selectedIconColor else unselectedIconColor

    TextButton(
        onClick = onSelected,
        colors = ButtonDefaults.textButtonColors(
            contentColor = textColor
        )
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "nav"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    NavBarComponent()
}