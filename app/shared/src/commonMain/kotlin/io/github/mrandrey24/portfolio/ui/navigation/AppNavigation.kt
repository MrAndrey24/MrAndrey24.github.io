package io.github.mrandrey24.portfolio.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.mrandrey24.portfolio.ui.components.TopNavBar
import io.github.mrandrey24.portfolio.ui.data.enums.Screen
import io.github.mrandrey24.portfolio.ui.screens.Home
import io.github.mrandrey24.portfolio.ui.screens.Posts

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
  var currentScreen by remember { mutableStateOf(Screen.HOME) }

  // Centered layout shell
  Box(
      modifier = modifier.fillMaxSize().padding(horizontal = 24.dp),
      contentAlignment = Alignment.TopCenter,
  ) {
    Column(modifier = Modifier.widthIn(max = 800.dp).fillMaxWidth()) {
      // Persistent Nav Header
      TopNavBar(currentScreen = currentScreen, onNavigate = { screen -> currentScreen = screen })

      // Content Area
      when (currentScreen) {
        Screen.HOME -> Home(onNavigate = { screen -> currentScreen = screen })
        Screen.POSTS -> Posts()
      }
    }
  }
}
