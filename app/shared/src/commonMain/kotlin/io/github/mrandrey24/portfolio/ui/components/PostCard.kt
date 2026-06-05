package io.github.mrandrey24.portfolio.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import io.github.mrandrey24.portfolio.ui.data.Props

@Composable
fun PostCard(post: Props, onClick: () -> Unit, modifier: Modifier = Modifier) {
  val isSoon = post.isComingSoon == true
  Column(
      modifier =
          modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(8.dp))
              .background(MaterialTheme.colorScheme.surface)
              .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(8.dp))
              .clickable { onClick() }
              .padding(16.dp)
  ) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
      // Title
      Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = post.title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
      }

      Spacer(modifier = Modifier.width(16.dp))

      // Date
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = post.publishedAt,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(end = 8.dp),
        )

        // Action
        if (isSoon) {
          Box(
              modifier =
                  Modifier.clip(RoundedCornerShape(4.dp))
                      .background(MaterialTheme.colorScheme.outline)
                      .padding(horizontal = 8.dp, vertical = 4.dp),
              contentAlignment = Alignment.Center,
          ) {
            Text(
                text = "Soon",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
          }
        } else {

          Icon(
              imageVector = Icons.AutoMirrored.Filled.OpenInNew,
              contentDescription = null,
              tint = MaterialTheme.colorScheme.primary,
              modifier = Modifier.size(14.dp),
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(8.dp))

    // Description
    Text(
        text = post.description,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
    )
  }
}
