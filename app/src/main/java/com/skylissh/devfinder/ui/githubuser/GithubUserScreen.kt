package com.skylissh.devfinder.ui.githubuser

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.skylissh.devfinder.ui.components.SearchUser
import com.skylissh.devfinder.ui.components.TopBar
import com.skylissh.devfinder.ui.components.githubcard.GithubCard
import com.skylissh.devfinder.ui.theme.DevFinderPadding
import com.skylissh.devfinder.ui.theme.DevFinderTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GithubUserScreen(
  githubUserVieWModel: GithubUserVieWModel = viewModel(),
  isDarkMode: Boolean,
  onToggle: (Boolean) -> Unit,
) {
  val scrollSate = rememberScrollState()
  val githubUserState by githubUserVieWModel.uiState.collectAsState()

  Scaffold { padding ->
    Box(
      modifier = Modifier.padding(
        horizontal = DevFinderPadding.Medium,
        vertical = padding.calculateBottomPadding()
      )
    ) {
      Column(modifier = Modifier.verticalScroll(scrollSate)) {
        TopBar(
          modifier = Modifier.padding(vertical = DevFinderPadding.Large),
          isDarkMode = isDarkMode,
          onToggle = onToggle,
        )
        SearchUser(
          modifier = Modifier.padding(bottom = DevFinderPadding.Medium),
          onSearch = { username ->
            githubUserVieWModel.findUser(username)
          },
        )
        githubUserState.user?.let { user ->
          GithubCard(user = user)
        }
      }
    }
  }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun GithubUserScreenPreview() {
  DevFinderTheme {
    GithubUserScreen(
      isDarkMode = isSystemInDarkTheme(),
      onToggle = {}
    )
  }
}
