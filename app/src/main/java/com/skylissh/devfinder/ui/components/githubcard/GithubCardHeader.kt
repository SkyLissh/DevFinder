package com.skylissh.devfinder.ui.components.githubcard

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.skylissh.devfinder.R
import com.skylissh.devfinder.extensions.format
import com.skylissh.devfinder.ui.theme.DevFinderPadding
import com.skylissh.devfinder.ui.theme.DevFinderTheme
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun GithubCardHeader(
  modifier: Modifier = Modifier,
  name: String,
  username: String,
  imageUrl: String,
  joinDate: LocalDateTime,
) {
  Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
    Box(
      modifier = Modifier
        .size(100.dp)
        .clip(CircleShape)
        .background(MaterialTheme.colorScheme.primary)
    ) {
      AsyncImage(
        model = imageUrl,
        contentDescription = stringResource(R.string.profile_picture),
      )
    }
    Spacer(modifier = Modifier.width(DevFinderPadding.Medium))
    Column {
      Text(
        name,
        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
      )
      Text(
        username,
        style = MaterialTheme.typography.labelMedium.copy(
          fontWeight = FontWeight.Bold,
          color = MaterialTheme.colorScheme.primary,
        )
      )
      Text(
        stringResource(R.string.joined_date, joinDate.format("dd MMM yyyy"))
      )
    }
  }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun GithubCardHeaderPreview() {
  val date = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

  DevFinderTheme {
    Surface {
      GithubCardHeader(
        modifier = Modifier.padding(DevFinderPadding.Medium),
        name = "Octocat",
        username = "@octocat",
        imageUrl = "https://picsum.photos/300/300",
        joinDate = date,
      )
    }
  }
}
