package io.github.mrandrey24.portfolio.ui.data

data class Props(
    val title: String,
    val publishedAt: String,
    val description: String,
    val slug: String,
    val isComingSoon: Boolean?,
)

val posts =
    listOf(
        Props(
            title = "Bus a lo Tico",
            publishedAt = "",
            description =
                "Solución multiplataforma para el monitoreo inteligente de autobuses en Costa Rica.",
            slug = "",
            isComingSoon = true,
        )
    )
