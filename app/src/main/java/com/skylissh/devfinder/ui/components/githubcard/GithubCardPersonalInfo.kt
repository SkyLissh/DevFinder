package com.skylissh.devfinder.ui.components.githubcard

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.skylissh.devfinder.R
import com.skylissh.devfinder.ui.theme.DevFinderPadding
import com.skylissh.devfinder.ui.theme.DevFinderTheme
import compose.icons.FeatherIcons
import compose.icons.feathericons.Briefcase
import compose.icons.feathericons.Link
import compose.icons.feathericons.MapPin
import compose.icons.feathericons.Twitter

@Composable
internal fun GithubCardPersonalInfo(
  location: String?,
  website: String?,
  twitter: String?,
  company: String?,
) {
  Column {
    RowInfo(
      icon = FeatherIcons.MapPin,
      info = location,
      description = stringResource(R.string.location)
    )
    Spacer(modifier = Modifier.height(DevFinderPadding.Medium))
    RowInfo(
      icon = FeatherIcons.Link,
      info = website,
      description = stringResource(R.string.website)
    )
    Spacer(modifier = Modifier.height(DevFinderPadding.Medium))
    RowInfo(
      icon = FeatherIcons.Twitter,
      info = twitter,
      description = stringResource(R.string.twitter)
    )
    Spacer(modifier = Modifier.height(DevFinderPadding.Medium))
    RowInfo(
      icon = FeatherIcons.Briefcase,
      info = company,
      description = stringResource(R.string.company)
    )
  }
}

@Composable
private fun RowInfo(icon: ImageVector, info: String? = null, description: String) {
  Row(verticalAlignment = Alignment.CenterVertically) {
    Icon(imageVector = icon, contentDescription = description)
    Spacer(modifier = Modifier.width(DevFinderPadding.Medium))
    Text(text = info ?: stringResource(R.string.not_available))
  }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun GithubCardPersonalInfoPreview() {
  DevFinderTheme {
    Surface {
      GithubCardPersonalInfo(
        location = "San Francisco",
        website = "https://github.blog",
        twitter = null,
        company = "@github",
      )
    }
  }
}
