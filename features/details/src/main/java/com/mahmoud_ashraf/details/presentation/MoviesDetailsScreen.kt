package com.mahmoud_ashraf.details.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
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
import com.google.accompanist.glide.rememberGlidePainter
import java.net.URLDecoder

@Composable
fun MoviesDetailsScreen(
    navController: NavController,
    movieId: String?,
    title: String?,
    image : String?
) {
    Scaffold(
        topBar = {
            CustomTopAppBar(navController,title)
        },

        content = {
            Log.e("id ",""+movieId)
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .padding(
                            start = 15.dp,
                            end = 15.dp,
                        )
                        .scrollable(
                            state = rememberScrollState(),
                            orientation = Orientation.Vertical
                        )
                ) {

                    Row {

                        // Poster
                        Poster(
                            modifier = Modifier
                                .requiredWidth(180.dp)
                                .requiredHeight(250.dp),
                            image?:"",
                            onMovieClicked = { /*TODO*/ }
                        )

                        // Meta
                        Column(
                            modifier = Modifier.padding(start = 12.dp)
                        ) {
                        }
                    }

                    // Title
                    Text(
                        text =title?:"",
                        modifier = Modifier.padding(
                            top = 10.dp,
                            bottom = 4.dp
                        ),
                        style = MaterialTheme.typography.h5
                    )

                    // IMDB Button
                    OutlinedButton(
                        onClick = {
                        }
                    ) {
                        Text(text = "OPEN IMDB")
                    }
                }
            }

        },
    )

}


@Composable
private fun CustomTopAppBar(navController: NavController, title: String?) {
    TopAppBar(
        title = {
            Text(
                text =title?:"",
                Modifier
                    .fillMaxWidth(),
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
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clickable {
                        navController.popBackStack()
                    },
                tint = Color.Red
            )
        }

    )
}

@Composable
fun Poster(
    modifier: Modifier = Modifier,
    image: String,
    onMovieClicked: (String) -> Unit
) {
    Card(
        modifier = Modifier.clickable(onClick = { onMovieClicked(image) })
    ) {
        val afterDecode: String = URLDecoder.decode(image, "UTF-8")

        Image(
            painter = rememberGlidePainter("http://image.tmdb.org/t/p/w185$afterDecode"),
            contentDescription = "image",
            modifier = modifier,
        )
    }
}


