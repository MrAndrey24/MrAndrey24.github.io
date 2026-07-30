package io.github.mrandrey24.portfolio.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikepenz.markdown.m3.Markdown
import org.jetbrains.compose.resources.ExperimentalResourceApi
import portfolio.app.shared.generated.resources.Res

@OptIn(ExperimentalResourceApi::class)
@Composable
fun PostDetail(slug: String, modifier: Modifier = Modifier) {

  var content by remember { mutableStateOf<String?>(null) }
  var error by remember { mutableStateOf<String?>(null) }

  LaunchedEffect(slug) {
    try {
      val bytes = Res.readBytes("drawable/$slug.md")
      content = bytes.decodeToString()
    } catch (e: Exception) {
      error = "The article could not be loaded: ${e.message}"
    }
  }

  Box(
      modifier =
          modifier
              .fillMaxSize()
              .verticalScroll(rememberScrollState())
              .padding(bottom = 48.dp, top = 24.dp),
      contentAlignment =
          if (content == null && error == null) Alignment.Center else Alignment.TopStart,
  ) {
    if (error != null) {
      Text(
          text = error!!,
          color = MaterialTheme.colorScheme.error,
          style = MaterialTheme.typography.bodyLarge,
      )
    } else if (content != null) {
      Markdown(content = content!!)
    } else {
      CircularProgressIndicator()
    }
  }
}
