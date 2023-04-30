package com.skylissh.devfinder.ui.githubuser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skylissh.devfinder.client
import com.skylissh.devfinder.models.GithubUser
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GithubUserVieWModel : ViewModel() {
  private val _uiState = MutableStateFlow(GithubUserState())
  val uiState = _uiState.asStateFlow()

  fun findUser(username: String) = viewModelScope.launch {
    val res = client.get("https://api.github.com/users/$username")
    println(res.bodyAsText())
    if (res.status == HttpStatusCode.OK) {
      val user: GithubUser = res.body()
      _uiState.value = GithubUserState(user)
    }
  }
}
