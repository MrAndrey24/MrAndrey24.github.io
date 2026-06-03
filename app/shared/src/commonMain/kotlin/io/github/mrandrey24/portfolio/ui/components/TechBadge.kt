package io.github.mrandrey24.portfolio.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import portfolio.app.shared.generated.resources.Res
import portfolio.app.shared.generated.resources.android
import portfolio.app.shared.generated.resources.firebase_wordmark
import portfolio.app.shared.generated.resources.kotlin
import portfolio.app.shared.generated.resources.swift

@Composable
fun TechBadge(
    name: String,
    modifier: Modifier = Modifier
) {
    val icons = when {
        name.contains("Kotlin", ignoreCase = true) -> Res.drawable.kotlin
        name.contains("Firebase", ignoreCase = true) -> Res.drawable.firebase_wordmark
        name.contains("Swift", ignoreCase = true) -> Res.drawable.swift
        name.contains("Android", ignoreCase = true) -> Res.drawable.android
        else -> null
    }

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
            .border(0.5.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f), RoundedCornerShape(6.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        if (icons != null) {
            Icon(
                painter = painterResource(icons),
                contentDescription = name,
                tint = Color.Unspecified,
                modifier = Modifier.size(
                    width = 46.dp,
                    height = 12.dp
                )
            )
        }
        Text(
            text = name,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary
        )
    }
}