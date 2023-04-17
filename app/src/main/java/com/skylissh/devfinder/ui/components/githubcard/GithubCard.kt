package com.skylissh.devfinder.ui.components.githubcard

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.skylissh.devfinder.ui.theme.DevFinderPadding
import com.skylissh.devfinder.ui.theme.DevFinderTheme
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun GithubCard(modifier: Modifier = Modifier) {
  Card(modifier = modifier.fillMaxWidth()) {
    Column(modifier = Modifier.padding(DevFinderPadding.Medium)) {
      GithubCardHeader(
        imageUrl = "https://picsum.photos/300/300",
        name = "Octocat",
        username = "@octocat",
        joinDate = Instant.parse("2023-04-15T22:14:04Z").toLocalDateTime(TimeZone.UTC)
      )
      Spacer(modifier = Modifier.height(DevFinderPadding.ExtraLarge))
      Text(
        "Legimus facilisi dictumst wisi tortor non eruditi. Placerat laoreet ius pertinacia tempor luctus novum appareat te. Ullamcorper sollicitudin quaestio habitant ullamcorper dicunt evertitur. Dictas tale quaerendum ut persequeris finibus definiebas comprehensam molestie. Ultricies novum has pertinacia aliquip semper mel eam tincidunt ceteros.",
        maxLines = 5,
        overflow = TextOverflow.Ellipsis,
      )
      Spacer(modifier = Modifier.height(DevFinderPadding.Large))
      GithubCardSocialInfo(repos = 8, followers = 3938, following = 9)
      Spacer(modifier = Modifier.height(DevFinderPadding.Large))
      GithubCardPersonalInfo(
        location = "San Francisco",
        website = "https://github.blog",
        twitter = null,
        company = "@github",
      )
    }
  }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun GithubCardPreview() {
  DevFinderTheme {
    Surface(color = MaterialTheme.colorScheme.background) {
      GithubCard(Modifier.padding(DevFinderPadding.Medium))
    }
  }
}
