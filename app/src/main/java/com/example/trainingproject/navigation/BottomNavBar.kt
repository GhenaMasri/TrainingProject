package com.example.trainingproject.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.trainingproject.R
import com.example.trainingproject.ui.theme.TrainingProjectTheme

@Composable
fun myBottomNavBar(navController: NavController, modifier: Modifier = Modifier) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavigationBar() {
        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
            },
            label = {
                Text(text = "Home")
            },
            selected = currentDestination?.route == Screens.ForYou.name,
            onClick = {
                navController.navigate(Screens.ForYou.name) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            })

        NavigationBarItem(icon = {
            Icon(
                painter = painterResource(id = R.drawable.nav_baseline_bookmarks),
                contentDescription = null
            )
        }, label = {
            Text(text = "Saved")
        }, selected = currentDestination?.route == Screens.Saved.name, onClick = {
            navController.navigate(Screens.Saved.name) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        })

        NavigationBarItem(icon = {
            Icon(painter = painterResource(id = R.drawable.hashtag), contentDescription = null)
        }, label = {
            Text(text = "Interests")
        }, selected = currentDestination?.route == Screens.Interests.name, onClick = {
            navController.navigate(Screens.Interests.name) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        })
    }
}


