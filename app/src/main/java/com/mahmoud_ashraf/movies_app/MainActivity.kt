package com.mahmoud_ashraf.movies_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mahmoud_ashraf.core.navigator.Navigator
import com.mahmoud_ashraf.home.data.repository.remote.MovieAPI
import com.mahmoud_ashraf.home.domain.MoviesRepository
import com.mahmoud_ashraf.home.presentation.HomeViewModel
import com.mahmoud_ashraf.movies_app.ui.theme.MoviesAppTheme
import com.mahmoud_ashraf.splash.SplashScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var aslv : MoviesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MoviesAppTheme {
                InitNavigation()
            }
        }



    }

    @Composable
    private fun InitNavigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Navigator.SplashScreen.route) {
            composable(Navigator.SplashScreen.route) {
                SplashScreen(navController = navController)
            }
            composable(Navigator.HomeScreen.route) {
             ScaffoldView()
            }
        }
    }

    @Composable
    private fun ScaffoldView() {
      val viewModel : HomeViewModel = hiltViewModel()
        Scaffold(
            topBar = {
                TopAppBar()
            },
            bottomBar = {
                BottomBar()
            },
            content = {
                Loading()
                viewModel.fetch()
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {}
                ) {
                    Icon(Icons.Filled.AccountBox, "")
                }
            })
    }
}

@Composable
fun TopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Movies App",
                Modifier.fillMaxWidth(),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Red,
                    fontFamily = FontFamily.Cursive
                )
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                tint = Color.Red
            )

            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                tint = Color.Red
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                tint = Color.Red
            )
        }
    )
}

@Composable
fun BottomBar() {
    BottomNavigation {
        BottomBarItem()
        BottomBarItem()
        BottomBarItem()
        BottomBarItem()
        BottomBarItem()
    }
}

@Composable
private fun RowScope.BottomBarItem() {
    BottomNavigationItem(
        selected = false,
        onClick = {},
        icon = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )
        }
    )
}

@Composable
private fun Loading() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(modifier = Modifier.size(48.dp))
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoviesAppTheme {
    }
}