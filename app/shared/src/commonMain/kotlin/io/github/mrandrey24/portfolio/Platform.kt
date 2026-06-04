package io.github.mrandrey24.portfolio

interface Platform {
  val name: String
}

expect fun getPlatform(): Platform
