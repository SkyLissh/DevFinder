package com.skylissh.devfinder.ui.githubuser

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.skylissh.devfinder.ui.components.SearchUser
import com.skylissh.devfinder.ui.components.TopBar
import com.skylissh.devfinder.ui.components.githubcard.GithubCard
import com.skylissh.devfinder.ui.theme.DevFinderPadding
import com.skylissh.devfinder.ui.theme.DevFinderTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GithubUserScreen() {
  val scrollSate = rememberScrollState()

  Scaffold {
    Box(
      modifier = Modifier.padding(
        horizontal = DevFinderPadding.Medium,
        vertical = it.calculateBottomPadding()
      )
    ) {
      Column(modifier = Modifier.verticalScroll(scrollSate)) {
        TopBar(modifier = Modifier.padding(vertical = DevFinderPadding.Large))
        SearchUser(modifier = Modifier.padding(bottom = DevFinderPadding.Medium))
        GithubCard()
      }
    }
  }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun GithubUserScreenPreview() {
  DevFinderTheme {
    GithubUserScreen()
  }
}
