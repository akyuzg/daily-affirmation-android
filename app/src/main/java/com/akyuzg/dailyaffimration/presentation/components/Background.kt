package com.akyuzg.dailyaffimration.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.akyuzg.dailyaffirmation.R

@Composable
fun BackgroundImage(@DrawableRes id: Int = R.drawable.bg ){
    Box( modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            painter = painterResource(id),
            contentDescription = null,
            contentScale = ContentScale.Crop,

        )
    }

}