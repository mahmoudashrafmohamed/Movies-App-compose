package com.mahmoud_ashraf.movies_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.mahmoud_ashraf.movies_app.ui.theme.MoviesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                Scaffold(
                    topBar = {
                        TopAppBar()
                    },
                    bottomBar = {
                        BottomBar()
                    },
                    content = {
                        Loading()
                    })
            }
        }
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
        backgroundColor = Color.White
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