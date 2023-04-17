package com.skylissh.devfinder.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.skylissh.devfinder.R

val spaceMonoFamily = FontFamily(
  Font(R.font.spacemono_regular, FontWeight.Normal),
  Font(R.font.spacemono_bold, FontWeight.Bold),
)

// Set of Material typography styles to start with
val Typography = Typography(
  labelMedium = TextStyle(
    fontFamily = spaceMonoFamily,
    fontWeight = FontWeight.Medium,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp
  ),
  bodyLarge = TextStyle(
    fontFamily = spaceMonoFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
  ),
  titleLarge = TextStyle(
    fontFamily = spaceMonoFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 22.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.sp
  ),
  headlineMedium = TextStyle(
    fontFamily = spaceMonoFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 28.sp,
    lineHeight = 36.sp,
    letterSpacing = 0.sp
  )
)