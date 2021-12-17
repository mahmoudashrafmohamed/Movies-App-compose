package com.mahmoud_ashraf.movies_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mahmoud_ashraf.core.navigator.Navigator
import com.mahmoud_ashraf.details.presentation.MoviesDetailsScreen
import com.mahmoud_ashraf.home.presentation.HomeScreen
import com.mahmoud_ashraf.movies_app.ui.theme.MoviesAppTheme
import com.mahmoud_ashraf.splash.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                InitNavigation()
            }
        }
    }

    @ExperimentalFoundationApi
    @Composable
    private fun InitNavigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Navigator.SplashScreen.route) {
            composable(Navigator.SplashScreen.route) {
                SplashScreen(navController = navController)
            }
            composable(Navigator.HomeScreen.route) {
                HomeScreen(navController = navController)
            }
            composable(route = Navigator.MoviesDetailsScreen.route+"/{movieId}",
                // set the type of args
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })) {
                /*
                You should extract the NavArguments from the NavBackStackEntry that is
                 available in the lambda of the composable() function.
                 */
                val movieId = it.arguments?.getString("movieId")
                MoviesDetailsScreen(navController = navController,movieId)
            }

        }
    }


}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoviesAppTheme {
    }
}