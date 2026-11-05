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
import portfolio.app.shared.generated.resources.django
import portfolio.app.shared.generated.resources.firebase
import portfolio.app.shared.generated.resources.golang
import portfolio.app.shared.generated.resources.java
import portfolio.app.shared.generated.resources.kotlin
import portfolio.app.shared.generated.resources.python
import portfolio.app.shared.generated.resources.spring
import portfolio.app.shared.generated.resources.swift

@Composable
fun TechBadge(name: String, modifier: Modifier = Modifier) {
  val icons =
      when {
        name.contains("Kotlin", ignoreCase = true) -> Res.drawable.kotlin
        name.contains("Firebase", ignoreCase = true) -> Res.drawable.firebase
        name.contains("Swift", ignoreCase = true) -> Res.drawable.swift
        name.contains("Android", ignoreCase = true) -> Res.drawable.android
        name.contains("Java", ignoreCase = true) -> Res.drawable.java
        name.contains("Spring Boot", ignoreCase = true) -> Res.drawable.spring
        name.contains("Django", ignoreCase = true) -> Res.drawable.django
        name.contains("Go", ignoreCase = true) -> Res.drawable.golang
        name.contains("Python", ignoreCase = true) -> Res.drawable.python
        else -> null
      }

  Row(
      modifier =
          modifier
              .clip(RoundedCornerShape(6.dp))
              .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
              .border(
                  0.5.dp,
                  MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                  RoundedCornerShape(6.dp),
              )
              .padding(horizontal = 8.dp, vertical = 4.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(6.dp),
  ) {
    if (icons != null) {
      Icon(
          painter = painterResource(icons),
          contentDescription = name,
          tint = Color.Unspecified,
          modifier = Modifier.size(12.dp),
      )
    }
    Text(
        text = name,
        style = MaterialTheme.typography.labelLarge,
        color = MaterialTheme.colorScheme.primary,
    )
  }
}
