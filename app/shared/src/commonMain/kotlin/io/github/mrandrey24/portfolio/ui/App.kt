package io.github.mrandrey24.portfolio.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.mrandrey24.portfolio.ui.navigation.AppNavigation
import io.github.mrandrey24.portfolio.ui.theme.PortfolioTheme

@Composable
@Preview
fun App() {
  PortfolioTheme {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
      AppNavigation()
    }
  }
}
