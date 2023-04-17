package com.skylissh.devfinder.extensions

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toJavaLocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDateTime.format(pattern: String): String {
  return DateTimeFormatter.ofPattern(pattern).format(this.toJavaLocalDateTime())
}
