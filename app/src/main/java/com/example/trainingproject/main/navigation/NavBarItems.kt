package com.example.trainingproject.main.navigation

import com.example.trainingproject.R

enum class NavBarItems(
    val label: Int,
    val icon: Int,
    val route: String,
) {
    FOR_YOU(
        label = R.string.home,
        icon = R.drawable.nav_home,
        route = Screens.ForYou.name
    ),
    SAVED(
        label = R.string.Saved,
        icon = R.drawable.nav_baseline_bookmarks,
        route = Screens.Saved.name
    ),
    INTERESTS(
        label = R.string.Interests,
        icon = R.drawable.hashtag,
        route = Screens.Interests.name
    ),

}