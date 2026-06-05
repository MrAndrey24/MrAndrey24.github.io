package io.github.mrandrey24.portfolio.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import portfolio.app.shared.generated.resources.Res
import portfolio.app.shared.generated.resources.flag_cr

@Composable
fun Header() {

  Column(modifier = Modifier.fillMaxWidth().padding(vertical = 32.dp)) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {

      // Hero Title
      Text(
          text = "Hi, I'm Andrey",
          style = MaterialTheme.typography.headlineLarge,
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

    Spacer(modifier = Modifier.padding(bottom = 24.dp))

    Text(
        text =
            "I'm a Software Engineer dedicated to crafting " +
                "high-performance cross-platform applications and scalable " +
                "backend systems. Currently focusing on building bridges " +
                "between mobile and web ecosystems.",
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.padding(bottom = 32.dp),
    )

    // Social Links Row
    RowSocialLinks()
  }
}
