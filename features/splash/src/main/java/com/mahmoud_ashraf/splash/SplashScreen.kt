package com.mahmoud_ashraf.splash

import android.util.Log
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navController: NavController
) {
    val scale = remember {
       Animatable(0.0f)
    }
    val overshootInterpolator = remember {
        OvershootInterpolator(10.0f)
    }
    Log.e("test","recompseed")
    LaunchedEffect(key1 = true) {

        scale.animateTo(
            targetValue = 2.5f,
            animationSpec = tween(
                durationMillis = 5000,
                easing = {
                    overshootInterpolator.getInterpolation(it)
                }
            )
        )
        delay(5000)
        navController.popBackStack()
        navController.navigate("home")

    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            imageVector= Icons.Filled.AccountBox,
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value)
        )
    }
}