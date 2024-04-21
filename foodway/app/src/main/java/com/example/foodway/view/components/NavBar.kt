 package com.example.foodway.view.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class NavBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavBarComponent()
        }
    }
}

@Composable
fun NavBarComponent() {
    val items = listOf("Home", "Perfil", "Configurações")
    var selectedIndex by remember { mutableStateOf(0) }
    val backgroundColor = Color.White
    val selectedItemTextColor = Color.Black
    val unselectedItemTextColor = Color.Gray
    val indicatorColor = Color.Blue
    val navBarHeight = 56.dp

    Surface(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .height(navBarHeight),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items.forEachIndexed { index, text ->
                NavBarItem(
                    text = text,
                    isSelected = index == selectedIndex,
                    onSelected = { selectedIndex = index },
                    selectedTextColor = selectedItemTextColor,
                    unselectedTextColor = unselectedItemTextColor,
                    indicatorColor = indicatorColor
                )
            }
        }
    }
}

@Composable
fun NavBarItem(
    text: String,
    isSelected: Boolean,
    onSelected: () -> Unit,
    selectedTextColor: Color,
    unselectedTextColor: Color,
    indicatorColor: Color
) {
    val textColor = if (isSelected) selectedTextColor else unselectedTextColor

    TextButton(
        onClick = onSelected,
        colors = ButtonDefaults.textButtonColors(
            contentColor = textColor
        )
    ) {
        Text(text = text, color = textColor)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavBarComponent()
}