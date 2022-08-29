package com.akyuzg.dailyaffirmation.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akyuzg.dailyaffirmation.ui.theme.White

@Composable
fun ErrorText(error: String) {
    if(error.isNotEmpty()){
        Text(
            color = White,
            text = error,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
    }
}