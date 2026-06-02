package io.github.mrandrey24.portfolio.ui.data

data class Project(
    val title: String,
    val techs: List<String>,
    val link: String,
    val isComingSoon: Boolean?
)
