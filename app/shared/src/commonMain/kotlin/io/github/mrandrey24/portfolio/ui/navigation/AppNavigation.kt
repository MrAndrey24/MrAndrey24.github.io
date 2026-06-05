package io.github.mrandrey24.portfolio.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.github.mrandrey24.portfolio.ui.screens.Home
import io.github.mrandrey24.portfolio.ui.screens.Posts

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
  val navController = rememberNavController()
  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val currentDestination = navBackStackEntry?.destination

  val isOnHome = currentDestination?.hasRoute<HomeRoute>() == true
  val isOnPost = currentDestination?.hasRoute<PostsRoute>() == true

  Scaffold(
      modifier = modifier,
      topBar = {
        Box(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
            contentAlignment = Alignment.TopCenter,
        ) {
          Column(modifier = Modifier.widthIn(max = 800.dp).fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
              Text(
                  text = "andreyacostar@gmail.com",
                  style = MaterialTheme.typography.labelLarge,
                  color = MaterialTheme.colorScheme.onSurfaceVariant,
              )

              Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Home",
                    style = MaterialTheme.typography.labelLarge,
                    color =
                        if (isOnHome) MaterialTheme.colorScheme.onSurface
                        else MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier =
                        Modifier.clickable {
                          navController.navigate(HomeRoute) {
                            popUpTo(HomeRoute) { inclusive = false }
                            launchSingleTop = true
                          }
                        },
                )

                Text(
                    text = "  /  ",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )

                Text(
                    text = "Posts",
                    style = MaterialTheme.typography.labelLarge,
                    color =
                        if (isOnPost) MaterialTheme.colorScheme.onSurface
                        else MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier =
                        Modifier.clickable {
                          navController.navigate(PostsRoute) { launchSingleTop = true }
                        },
                )
              }
            }
          }
        }
      },
  ) { innerPadding ->
    Box(
        modifier = Modifier.fillMaxSize().padding(innerPadding).padding(horizontal = 24.dp),
        contentAlignment = Alignment.TopCenter,
    ) {
      Box(modifier = Modifier.widthIn(max = 800.dp).fillMaxWidth()) {
        NavHost(
            navController = navController,
            startDestination = HomeRoute,
            modifier = Modifier.fillMaxSize(),
        ) {
          composable<HomeRoute> {
            Home(
                onNavigatePosts = { navController.navigate(PostsRoute) { launchSingleTop = true } }
            )
          }

          composable<PostsRoute> { Posts() }
        }
      }
    }
  }
}
