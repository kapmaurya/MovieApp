package com.example.movieapp.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.MovieRow
import com.example.movieapp.navagation.MovieScreens


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar() {
            //Text(text = "movies")
        }
    },){
        MainContent(navController=navController)
    }
}

fun TopAppBar(scrollBehavior: () -> Unit) {

}

@Composable
fun MainContent(navController: NavController,
    movieList: List<String> = listOf(
    "DHOOM",
    "Animal",
    "RRR",
    "KGF",
    "GADAR")){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items = movieList){
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")


                }
            }
        }
    }
}