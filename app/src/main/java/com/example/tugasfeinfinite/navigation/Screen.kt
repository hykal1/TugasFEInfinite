package com.example.tugasfeinfinite.navigation

sealed class Screen (val route: String){
    data object Home : Screen("home")
    data object Gallery : Screen("galery")
    data object About : Screen("about")
    data object Detail : Screen("detail")
    data object StudentDetail : Screen("StudentDetail")
}