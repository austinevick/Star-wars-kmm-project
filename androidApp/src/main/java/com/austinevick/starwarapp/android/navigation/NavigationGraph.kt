package com.austinevick.starwarapp.android.navigation

import android.R.attr.type
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.austinevick.starwarapp.android.ui.CharacterDetail
import com.austinevick.starwarapp.android.ui.StarshipScreen
import com.austinevick.starwarapp.android.ui.HomeScreen
import com.austinevick.starwarapp.android.ui.StarshipDetail
import com.austinevick.starwarapp.data.model.CharacterData
import com.austinevick.starwarapp.data.model.CharacterModel
import com.austinevick.starwarapp.data.model.StarshipData
import com.austinevick.starwarapp.theme.ThemeViewModel
import com.google.gson.Gson

@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    viewModel: ThemeViewModel,
    navController: NavHostController
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Routes.Character.route
    ) {
        composable(Routes.Character.route) {
            HomeScreen(navController, viewModel)
        }
        composable(Routes.CharacterDetail.route+"/{character}",
            arguments = listOf(navArgument("character"){
                type = NavType.StringType
            })) {
            val character = it.arguments?.getString("character")
            val data = Gson().fromJson(character, CharacterData::class.java)
            CharacterDetail(navController, data)
        }

        composable(Routes.Starships.route) {
            StarshipScreen(navController, viewModel)
        }

        composable(Routes.StarshipsDetail.route+"/{starship}",
            arguments = listOf(navArgument("starship"){
                type = NavType.StringType
            })) {
            val starship = it.arguments?.getString("starship")
            val data = Gson().fromJson(starship, StarshipData::class.java)
            StarshipDetail(navController, data)
        }

    }
}