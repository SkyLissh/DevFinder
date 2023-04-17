package com.skylissh.devfinder.ui.components.githubcard

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.skylissh.devfinder.R
import com.skylissh.devfinder.ui.theme.DevFinderPadding
import com.skylissh.devfinder.ui.theme.DevFinderTheme
import com.skylissh.devfinder.ui.theme.shapes

@Composable
internal fun GithubCardSocialInfo(repos: Int, followers: Int, following: Int) {
  val titles = listOf(
    stringResource(R.string.repos),
    stringResource(R.string.followers),
    stringResource(R.string.following),
  )

  Surface(
    modifier = Modifier.fillMaxWidth(),
    color = MaterialTheme.colorScheme.background,
    shape = shapes.medium,
  ) {
    Row(
      modifier = Modifier.padding(vertical = DevFinderPadding.Medium),
      horizontalArrangement = Arrangement.SpaceEvenly
    ) {
      for ((title, data) in titles.zip(listOf(repos, followers, following))) {
        InfoColumn(title, data)
      }
    }
  }
}

@Composable
private fun InfoColumn(title: String, data: Int) {
  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Text(title, style = MaterialTheme.typography.labelMedium)
    Spacer(modifier = Modifier.height(DevFinderPadding.Medium))
    Text(
      "$data",
      style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
    )
  }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun GithubCardSocialInfoPreview() {
  DevFinderTheme {
    GithubCardSocialInfo(repos = 8, followers = 3938, following = 9)
  }
}
