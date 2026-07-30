package io.github.mrandrey24.portfolio.ui.navigation

import kotlinx.serialization.Serializable

@Serializable object HomeRoute

@Serializable object PostsRoute

@Serializable data class PostDetailRoute(val slug: String)
