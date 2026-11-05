/**
 * MIT License
 *
 * Copyright (c) 2026 Andrey Acosta  Ramirez
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.github.mrandrey24.portfolio.ui.screens

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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import io.github.mrandrey24.portfolio.ui.components.Header
import io.github.mrandrey24.portfolio.ui.components.PostCard
import io.github.mrandrey24.portfolio.ui.components.ProjectCard
import io.github.mrandrey24.portfolio.ui.components.RowSocialLinks
import io.github.mrandrey24.portfolio.ui.data.posts
import io.github.mrandrey24.portfolio.ui.data.projects
import org.jetbrains.compose.resources.painterResource
import portfolio.app.shared.generated.resources.Res
import portfolio.app.shared.generated.resources.flag_cr

@Composable
fun Home(
    onNavigatePosts: () -> Unit,
    onNavigatePostDetail: (String) -> Unit,
    modifier: Modifier = Modifier,
    uriHandler: UriHandler = LocalUriHandler.current,
) {
  Column(
      modifier =
          modifier.fillMaxWidth().verticalScroll(rememberScrollState()).padding(bottom = 48.dp)
  ) {
    // Hero Header
    Header()

    Spacer(modifier = Modifier.height(24.dp))

    // Latest Posts Section
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
      Text(
          text = "Latest posts",
          style = MaterialTheme.typography.titleLarge,
          color = MaterialTheme.colorScheme.onBackground,
      )

      Text(
          text = "See all posts",
          style = MaterialTheme.typography.labelLarge,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          textDecoration = TextDecoration.Underline,
          modifier = Modifier.clickable { onNavigatePosts() },
      )
    }

    Spacer(modifier = Modifier.height(16.dp))

    // Render latest post
    posts.firstOrNull()?.let { post ->
      PostCard(
          post = post,
          onClick = {
            if (post.isComingSoon != true) {
              onNavigatePostDetail(post.slug)
            }
          },
      )
    }

    Spacer(modifier = Modifier.height(48.dp))

    // Selected Projects Section
    Text(
        text = "Selected projects (${projects.size})",
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onBackground,
    )

    Spacer(modifier = Modifier.height(16.dp))

    // Projects List
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
      projects.forEach { project ->
        ProjectCard(project = project, onClick = { uriHandler.openUri(project.link) })
      }
    }

    Spacer(modifier = Modifier.height(48.dp))

    // Get in touch Section
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      Text(
          text = "Get in touch",
          style = MaterialTheme.typography.titleLarge,
          color = MaterialTheme.colorScheme.onBackground,
      )

      Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.spacedBy(4.dp),
      ) {
        Icon(
            painter = painterResource(Res.drawable.flag_cr),
            contentDescription = "Costa Rica Flag",
            tint = Color.Unspecified,
            modifier = Modifier.size(width = 14.dp, height = 9.dp),
        )
      }
    }

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = "Email me at andreyacostar@gmail.com or follow me via my social links.",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
    )

    Spacer(modifier = Modifier.height(24.dp))

    // Footer
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
    ) {
      RowSocialLinks()
    }
  }
}
