package com.akyuzg.dailyaffirmation.presentation.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.akyuzg.dailyaffirmation.presentation.theme.White

@Composable
fun LoadingIndicator(isLoading: Boolean) {
    if(isLoading){
        CircularProgressIndicator(
            color = White,
            strokeWidth = 3.dp
        )
    }
}