package com.akyuzg.presentation.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.path.presentation.R

@Composable
fun Logo() {
    Image(
        painter = painterResource(id = R.drawable.app_logo),
        contentDescription = "App Logo",
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(80.dp),
        alignment = Alignment.Center
    )
}
