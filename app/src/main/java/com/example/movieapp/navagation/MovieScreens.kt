package com.example.movieapp.navagation

import java.lang.IllegalArgumentException

enum class MovieScreens{
    HomeScreen,
    DetailsScreen;
    companion object{
        fun fromRoute(route:String?): MovieScreens
        = when(route?.substringBefore(delimiter = "/")){
            HomeScreen.name->HomeScreen
            DetailsScreen.name->DetailsScreen
            null->HomeScreen
            else->throw IllegalArgumentException("Route $route in not recognize")

        }
    }
}