package com.skylissh.devfinder.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.skylissh.devfinder.R
import com.skylissh.devfinder.ui.theme.DevFinderPadding
import com.skylissh.devfinder.ui.theme.DevFinderTheme
import compose.icons.FeatherIcons
import compose.icons.feathericons.Moon
import compose.icons.feathericons.Sun

@Composable
fun TopBar(
  modifier: Modifier = Modifier,
  isDarkMode: Boolean,
  onToggle: (Boolean) -> Unit,
) {
  Row(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(
      stringResource(R.string.bar_title),
      style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
    )
    ToggleThemeButton(isDarkMode, onToggle)
  }
}

@Composable
private fun ToggleThemeButton(isDarkMode: Boolean, onToggle: (Boolean) -> Unit) {
  val toggleThemeLabel = stringResource(R.string.toggle_theme)
  val text = if (isDarkMode) {
    stringResource(R.string.dark_theme)
  } else {
    stringResource(R.string.light_theme)
  }

  val icon = if (isDarkMode) FeatherIcons.Moon else FeatherIcons.Sun

  TextButton(
    modifier = Modifier.semantics(mergeDescendants = true) {
      onClick(label = toggleThemeLabel, action = null)
    },
    onClick = { onToggle(!isDarkMode) }
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Text(
        text,
        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
        color = MaterialTheme.colorScheme.onBackground,
      )
      Spacer(modifier = Modifier.width(DevFinderPadding.Medium))
      Icon(
        icon,
        contentDescription = null,
        tint = MaterialTheme.colorScheme.onBackground,
      )
    }
  }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun TopBarPreview() {
  DevFinderTheme {
    Surface(color = MaterialTheme.colorScheme.background) {
      TopBar(
        modifier = Modifier.padding(DevFinderPadding.Medium),
        isDarkMode = isSystemInDarkTheme(),
        onToggle = {},
      )
    }
  }
}
