package com.mahmoud_ashraf.home.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ErrorView(message: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(message)
        Spacer(modifier = Modifier.height(24.dp))
        Icon(
            imageVector = Icons.Filled.Face,
            contentDescription =message,
            modifier = Modifier
                .size(40.dp)
               
        )
    }
}

@Preview
@Composable
private fun ErrorColumnPreview() {
    ErrorView(message = "Error Happened!")
}