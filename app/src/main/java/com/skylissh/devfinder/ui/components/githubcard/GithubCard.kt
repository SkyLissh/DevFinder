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
import com.skylissh.devfinder.models.GithubUser
import com.skylissh.devfinder.ui.theme.DevFinderPadding
import com.skylissh.devfinder.ui.theme.DevFinderTheme
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun GithubCard(modifier: Modifier = Modifier, user: GithubUser) {
  Card(modifier = modifier.fillMaxWidth()) {
    Column(modifier = Modifier.padding(DevFinderPadding.Medium)) {
      GithubCardHeader(
        imageUrl = user.avatar,
        name = user.name,
        username = "@${user.username}",
        joinDate = Instant
          .parse("2023-04-15T22:14:04Z")
          .toLocalDateTime(TimeZone.UTC)
      )
      Spacer(modifier = Modifier.height(DevFinderPadding.ExtraLarge))

      Text(user.bio, maxLines = 5, overflow = TextOverflow.Ellipsis)

      Spacer(modifier = Modifier.height(DevFinderPadding.Large))

      GithubCardSocialInfo(
        repos = user.repos,
        followers = user.followers,
        following = user.following,
      )

      Spacer(modifier = Modifier.height(DevFinderPadding.Large))

      GithubCardPersonalInfo(
        location = user.location,
        website = user.website,
        twitter = user.twitter,
        company = user.company,
      )
    }
  }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun GithubCardPreview() {
  val date = Instant.parse("2023-04-15T22:04:12Z")

  val user = GithubUser(
    name = "Octocat",
    username = "octocat",
    createdAt = date,
    avatar = "https://picsum.photos/300/300",
    bio = "hello, my name is Octocat",
    repos = 8,
    followers = 3938,
    following = 9,
    company = "GitHub",
    location = "San Francisco",
    twitter = null,
    website = "https://github.blog"
  )

  DevFinderTheme {
    Surface(color = MaterialTheme.colorScheme.background) {
      GithubCard(modifier = Modifier.padding(DevFinderPadding.Medium), user = user)
    }
  }
}
