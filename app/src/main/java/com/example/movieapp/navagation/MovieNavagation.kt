package com.example.movieapp.navagation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.home.HomeScreen
import com.example.movieapp.screens.details.DetailsScreen


@Composable
fun MovieNavagation()
{
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name  ){
        composable(MovieScreens.HomeScreen.name){
         HomeScreen(navController=navController)
        }

        composable(MovieScreens.DetailsScreen.name+"/{movie}",
            arguments = listOf(navArgument(name = "movie"){ type= NavType.StringType})){
            backStackEntry ->
            DetailsScreen(navController=navController,
                backStackEntry.arguments?.getString("movie"))
        }
    }
}
