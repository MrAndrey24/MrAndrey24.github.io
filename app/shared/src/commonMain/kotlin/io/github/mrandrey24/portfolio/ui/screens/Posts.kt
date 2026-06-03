package io.github.mrandrey24.portfolio.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.mrandrey24.portfolio.ui.components.PostCard
import io.github.mrandrey24.portfolio.ui.data.posts

@Composable
fun Posts(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 48.dp)
    ) {
        // Page Title
        Text(
            text = "Posts",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(vertical = 24.dp)
        )

        // Divider
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp),
            color = MaterialTheme.colorScheme.outline
        )

        // Posts List
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            posts.forEach { post ->
                PostCard(
                    post = post,
                    onClick = { /* Navigate to post details */ }
                )
            }
        }
    }
}