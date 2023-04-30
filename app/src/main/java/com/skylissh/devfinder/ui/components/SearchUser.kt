package com.skylissh.devfinder.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skylissh.devfinder.R
import com.skylissh.devfinder.ui.theme.BlueGrey80
import com.skylissh.devfinder.ui.theme.DevFinderPadding
import com.skylissh.devfinder.ui.theme.DevFinderTheme
import com.skylissh.devfinder.ui.theme.shapes
import compose.icons.FeatherIcons
import compose.icons.feathericons.Search

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchUser(modifier: Modifier = Modifier, onSearch: (String) -> Unit) {
  var field by remember { mutableStateOf(TextFieldValue("")) }

  OutlinedTextField(
    modifier = modifier
      .fillMaxWidth()
      .shadow(
        elevation = 6.dp,
        shape = shapes.medium,
        ambientColor = BlueGrey80,
      ),
    value = field,
    placeholder = { Text(stringResource(R.string.search_placeholder)) },
    onValueChange = { field = it },
    singleLine = true,
    trailingIcon = {
      IconButton(onClick = { onSearch(field.text) }) {
        Icon(
          FeatherIcons.Search,
          contentDescription = null,
          tint = MaterialTheme.colorScheme.primary,
        )
      }
    },
    colors = TextFieldDefaults.outlinedTextFieldColors(
      unfocusedBorderColor = Color.Transparent,
      containerColor = MaterialTheme.colorScheme.surfaceVariant,
    ),
    shape = shapes.medium,
  )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun SearchUserPreview() {
  DevFinderTheme {
    Surface(color = MaterialTheme.colorScheme.background) {
      SearchUser(
        modifier = Modifier.padding(DevFinderPadding.Medium),
        onSearch = {  },
      )
    }
  }
}

