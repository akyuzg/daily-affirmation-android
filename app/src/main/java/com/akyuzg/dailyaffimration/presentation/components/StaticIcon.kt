package com.akyuzg.dailyaffimration.presentation.components

import androidx.compose.ui.graphics.Color
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun StaticIcon(
    @DrawableRes
    id: Int,
    color: Color = Color.Black
){
    val image: Painter = painterResource(id = id)
    Image(
        colorFilter = ColorFilter.tint(color),
        painter = image,
        contentDescription = "",
        modifier = Modifier
            .size(64.dp)
            .padding(12.dp)
    )
}