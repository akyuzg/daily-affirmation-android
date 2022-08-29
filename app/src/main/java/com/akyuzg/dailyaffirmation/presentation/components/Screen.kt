package com.akyuzg.dailyaffirmation.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.akyuzg.dailyaffirmation.R
import com.akyuzg.dailyaffirmation.ui.theme.ScreenBackgroundColor


@Composable
fun ScreenSpacer(){
    val spacerModifier = Modifier.height(dimensionResource(R.dimen.mediumPadding))
    Spacer(spacerModifier)
}

@Composable
fun Screen(
    content: @Composable () -> Unit
){
    val spacerModifier = Modifier.height(dimensionResource(R.dimen.largePadding))
    Column(modifier = Modifier
        .background(ScreenBackgroundColor)
        .fillMaxSize()
        .padding(horizontal = dimensionResource(id = R.dimen.mediumPadding))

    ) {
        Spacer(spacerModifier)
        content()
    }
}