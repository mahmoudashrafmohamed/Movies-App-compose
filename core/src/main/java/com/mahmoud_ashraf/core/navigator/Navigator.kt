package com.mahmoud_ashraf.core.navigator

sealed class Navigator(val route: String) {
    object SplashScreen : Navigator("splash_screen")
    object HomeScreen : Navigator("home_screen")
}