package com.akyuzg.dailyaffimration.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akyuzg.dailyaffimration.presentation.theme.White

@Composable
fun WelcomeText() {
    Column(
        modifier =  Modifier
            .height(200.dp)
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hoşgeldin!",
            fontSize = 24.sp,
            color = White,
            fontWeight = FontWeight.Bold

        )
        Text(
            modifier = Modifier.padding(PaddingValues(top = 10.dp)),
            text = "Günlük olumlamalarla hayatını pozitif yönde etkile",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = White,
            fontWeight = FontWeight.Light,
            lineHeight = 32.sp
        )
    }
}

@Preview
@Composable
fun WelcomeTextPreview(){
    WelcomeText()
}