package io.github.mrandrey24.portfolio.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Zinc100,
    onPrimary = Zinc950,
    primaryContainer = Zinc900,
    onPrimaryContainer = Zinc100,
    secondary = Amber500,
    onSecondary = Zinc950,
    background = Zinc950,
    onBackground = Zinc100,
    surface = Zinc900,
    onSurface = Zinc100,
    surfaceVariant = Zinc900,
    onSurfaceVariant = Zinc400,
    outline = Zinc800
)

@Composable
fun PortfolioTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = PortfolioTypography,
        content = content
    )
}
