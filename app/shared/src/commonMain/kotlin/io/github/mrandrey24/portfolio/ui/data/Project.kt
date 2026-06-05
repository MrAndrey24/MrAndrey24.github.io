package io.github.mrandrey24.portfolio.ui.data

data class Project(
    val title: String,
    val techs: List<String>,
    val link: String,
    val isComingSoon: Boolean?,
)

val projects =
    listOf(
        Project(
            title = "Bus a lo Tico",
            techs = listOf("Kotlin Multiplatform", "Firebase", "Android", "Swift"),
            link = "https://github.com/MrAndrey24/Bus-A-Lo-Tico",
            isComingSoon = false,
        ),
        Project(
            title = "Portfolio",
            techs = listOf("Kotlin Multiplatform"),
            link = "/",
            isComingSoon = false,
        ),
    )
