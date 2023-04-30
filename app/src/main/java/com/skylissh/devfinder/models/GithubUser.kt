package com.skylissh.devfinder.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubUser(
  val name: String,
  val bio: String,
  @SerialName("avatar_url")
  val avatar: String,
  val followers: Int,
  val following: Int,
  @SerialName("public_repos")
  val repos: Int,
  val location: String?,
  @SerialName("twitter_username")
  val twitter: String?,
  val company: String?,
  @SerialName("blog")
  val website: String?,
  @SerialName("login")
  val username: String,
  @SerialName("created_at")
  val createdAt: Instant,
)
