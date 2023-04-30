package com.skylissh.devfinder

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DevFinderViewModel : ViewModel() {
  val _state = MutableStateFlow(DevFinderState())
  val state = _state.asStateFlow()

  fun setDarkMode(isDark: Boolean) {
    _state.value = DevFinderState(isDark)
  }
}
