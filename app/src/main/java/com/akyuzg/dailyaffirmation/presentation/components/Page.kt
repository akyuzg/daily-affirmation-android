package com.akyuzg.dailyaffirmation.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.akyuzg.dailyaffirmation.R

@Composable
fun Page(
    loading: Boolean,
    error: String,
    content: @Composable() () -> Unit
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        BackgroundImage(id = R.drawable.initial_affirmation_bg)
        LoadingIndicator(loading)
        ErrorText(error)
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            content()
        }
    }
}