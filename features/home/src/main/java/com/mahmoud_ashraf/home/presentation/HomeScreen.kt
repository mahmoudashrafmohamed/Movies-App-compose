package com.mahmoud_ashraf.home.presentation

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel : HomeViewModel
) {
    val state by viewModel.message.observeAsState()
    Log.e("recompose","+++")
    Scaffold(
        topBar = {
            TopAppBar()
        },
        bottomBar = {
            BottomBar()
        },
        content = {
            Loading()
            //Todo fix bug here -> fetch is called more than once.
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
fun RowScope.BottomBarItem() {
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
 fun Loading() {
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
