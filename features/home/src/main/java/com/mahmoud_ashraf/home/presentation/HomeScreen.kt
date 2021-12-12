package com.mahmoud_ashraf.home.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.glide.rememberGlidePainter
import com.mahmoud_ashraf.home.data.model.Movie

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel : HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.observeAsState()
    Log.e("recompose","+++")
    Scaffold(
        topBar = {
            TopAppBar()
        },
        bottomBar = {
            BottomBar()
        },
        content = {innerPadding->
            when (uiState) {
                is ResultStates.Loading -> Loading()
                is ResultStates.Success -> {
                    val moviesList = (uiState as? ResultStates.Success)?.movies?.results?: listOf()
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(bottom = innerPadding.calculateBottomPadding()),
                    ) {

                        itemsIndexed(moviesList) { _, it ->
                            MovieCard(movie = it, onClick = {  })
                        }
                    }
                }
                else -> ErrorView(message = "Something wrong happened!")
            }

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
fun MovieCard(movie: Movie, onClick: () -> Unit) {
    val padding = 16.dp
    Column(
        Modifier
            .clickable(onClick = onClick)
            .padding(
                top = padding / 2,
                start = padding,
                end = padding,
                bottom = padding / 2
            )
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    movie.title?:"",
                    style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Medium)
                )

            }
        }
        Spacer(Modifier.size(padding))
        Image(
          painter =  rememberGlidePainter("https://image.api.playstation.com/vulcan/img/rnd/202011/0714/vuF88yWPSnDfmFJVTyNJpVwW.png"),
            contentDescription = "main image",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .shadow(elevation = 4.dp, clip = true, shape = RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )
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
        BottomBarItem( Icons.Filled.Home)
        BottomBarItem( Icons.Filled.Search)
        BottomBarItem( Icons.Filled.Favorite)
        BottomBarItem( Icons.Filled.Settings)
        BottomBarItem( Icons.Filled.Share)
    }
}

@Composable
fun RowScope.BottomBarItem(imageVector: ImageVector) {
    BottomNavigationItem(
        selected = false,
        onClick = {},
        icon = {
            Icon(
                imageVector = imageVector,
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
