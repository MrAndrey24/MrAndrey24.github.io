package io.github.mrandrey24.portfolio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Link
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import io.github.mrandrey24.portfolio.ui.components.Header
import io.github.mrandrey24.portfolio.ui.components.PostCard
import io.github.mrandrey24.portfolio.ui.components.ProjectCard
import io.github.mrandrey24.portfolio.ui.data.enums.Screen
import io.github.mrandrey24.portfolio.ui.data.posts
import io.github.mrandrey24.portfolio.ui.data.projects
import org.jetbrains.compose.resources.painterResource
import portfolio.app.shared.generated.resources.Res
import portfolio.app.shared.generated.resources.flag_cr
import portfolio.app.shared.generated.resources.github_dark
import portfolio.app.shared.generated.resources.linkedin

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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Get in touch",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    painter = painterResource(Res.drawable.flag_cr),
                    contentDescription = "Costa Rica Flag",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(width = 14.dp, height = 9.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Email me at andreyacostar@gmail.com or follow me via my social links.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Footer
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            val links = listOf(
                "Github" to "https://github.com/MrAndrey24",
                "LinkedIn" to "https://www.linkedin.com/in/aacostar24/"
            )
            links.forEach { (linkName, url) ->
                val painter = when (linkName.lowercase()) {
                    "github" -> painterResource(Res.drawable.github_dark)
                    "linkedin" -> painterResource(Res.drawable.linkedin)
                    else -> null
                }

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.surface)
                        .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(8.dp))
                        .clickable { uriHandler.openUri(url) }
                        .padding(horizontal = 14.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (painter != null) {
                        Icon(
                            painter = painter,
                            contentDescription = linkName,
                            tint = Color.Unspecified,
                            modifier = Modifier.size(16.dp)
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Link,
                            contentDescription = linkName,
                            tint = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Text(
                        text = linkName,
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}