package com.example.foodway.presentation.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import com.example.foodway.R

val quicksandFontFamily = FontFamily(
    Font(R.font.quicksand, FontWeight.Normal),
    Font(R.font.quicksand_light, FontWeight.Light),
    Font(R.font.quicksand_bold, FontWeight.Bold),
    Font(R.font.quicksand_medium, FontWeight.Medium)
)

val Typography = Typography(
    defaultFontFamily = quicksandFontFamily,
    h4 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        letterSpacing = 0.sp
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        letterSpacing = 0.sp
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        letterSpacing = 0.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        letterSpacing = 0.5.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 11.sp,
        letterSpacing = 0.5.sp
    )
)
