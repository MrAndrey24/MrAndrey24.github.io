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
import androidx.navigation.toRoute
import io.github.mrandrey24.portfolio.ui.screens.Home
import io.github.mrandrey24.portfolio.ui.screens.PostDetail
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
                onNavigatePosts = { navController.navigate(PostsRoute) { launchSingleTop = true } },
                onNavigatePostDetail = { slug ->
                  navController.navigate(PostDetailRoute(slug)) { launchSingleTop = true }
                },
            )
          }

          composable<PostsRoute> {
            Posts(
                onNavigatePostDetail = { slug ->
                  navController.navigate(PostDetailRoute(slug)) { launchSingleTop = true }
                },
                onBack = { navController.popBackStack() },
            )
          }

          composable<PostDetailRoute> { backStackEntry ->
            val route: PostDetailRoute = backStackEntry.toRoute()
            PostDetail(
                slug = route.slug,
                onBack = { navController.popBackStack() },
            )
          }
        }
      }
    }
  }
}
