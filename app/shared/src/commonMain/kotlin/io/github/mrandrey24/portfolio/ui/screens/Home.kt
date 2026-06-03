package io.github.mrandrey24.portfolio.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import io.github.mrandrey24.portfolio.ui.components.Header
import io.github.mrandrey24.portfolio.ui.components.PostCard
import io.github.mrandrey24.portfolio.ui.components.ProjectCard
import io.github.mrandrey24.portfolio.ui.data.enums.Screen
import io.github.mrandrey24.portfolio.ui.data.posts
import io.github.mrandrey24.portfolio.ui.data.projects

@Composable
fun Home(
    onNavigate: (Screen) -> Unit,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 48.dp)
    ) {
        // Hero Header
        Header()

        Spacer(modifier = Modifier.height(24.dp))

        // Latest Posts Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Latest posts",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = "See all posts",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { onNavigate(Screen.POSTS) }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Render latest post
        posts.firstOrNull()?.let { post ->
            PostCard(
                post = post,
                onClick = { /* Navigate to post details / link */ }
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        // Selected Projects Section
        Text(
            text = "Selected projects (${projects.size})",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Projects List
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            projects.forEach { project ->
                ProjectCard(
                    project = project,
                    onClick = {
                        uriHandler.openUri(project.link)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(48.dp))

        // Get in touch Section
        Text(
            text = "Get in touch",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Email me at andreyacostar@gmail.com or follow me via my social links.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Footer
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            val links = listOf(
                "Github" to "https://github.com/MrAndrey24",
                "LinkedIn" to "https://www.linkedin.com/in/aacostar24/"
            )
            links.forEachIndexed { index, (linkName, url) ->
                Text(
                    text = linkName,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.clickable {
                        uriHandler.openUri(url)
                    }
                )

                if (index < links.lastIndex) {
                    Text(
                        text = "  /  ",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}