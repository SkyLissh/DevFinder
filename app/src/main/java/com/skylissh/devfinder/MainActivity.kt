package com.skylissh.devfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.skylissh.devfinder.ui.githubuser.GithubUserScreen
import com.skylissh.devfinder.ui.theme.DevFinderTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val devFinderViewModel: DevFinderViewModel = viewModel()
      val state by devFinderViewModel.state.collectAsState()

      val isDark = state.isDark ?: isSystemInDarkTheme()

      DevFinderTheme(darkTheme = isDark) {
        GithubUserScreen(
          isDarkMode = isDark,
          onToggle = { value -> devFinderViewModel.setDarkMode(value) },
        )
      }
    }
  }
}
