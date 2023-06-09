package com.skylissh.devfinder.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
  primary = Blue80,
  background = DeepBlue800,
  surface = DeepBlue600,
  onSurfaceVariant = Color.White,
  onSurface = Color.White,
  surfaceVariant = DeepBlue600,
)

private val LightColorScheme = lightColorScheme(
  primary = Blue80,
  background = BlueGray200,
  onSurface = DeepBlue800,
  onSurfaceVariant = DeepBlue800,
  surfaceVariant = Color.White,
)

@Composable
fun DevFinderTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit,
) {
  val colorScheme = when {
    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }
  val view = LocalView.current
  val window = (view.context as Activity).window
  window.statusBarColor = colorScheme.background.toArgb()

  WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    shapes = shapes,
    content = content
  )
}