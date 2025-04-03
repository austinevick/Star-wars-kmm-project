package com.austinevick.starwarapp.android.data

import com.austinevick.starwarapp.android.R
import com.austinevick.starwarapp.android.navigation.Routes


data class NavigationItem (
    val route: String,
    val activeIcon: Int
)

val navigationItems = listOf(
    NavigationItem(
        route = Routes.Character.route,
        activeIcon = R.drawable.home_filled
    ),
    NavigationItem(
        route = Routes.Starships.route,
        activeIcon = R.drawable.shield
    )
)