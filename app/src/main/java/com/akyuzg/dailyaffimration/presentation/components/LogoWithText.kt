package com.akyuzg.dailyaffimration.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.akyuzg.dailyaffimration.presentation.theme.White

@Composable
fun LogoWithText(){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Logo()
        Text(
            text = "motto",
            fontWeight = FontWeight.Bold,
            color = White,
            fontSize = 30.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun LogoWithTextPreview() {
    LogoWithText()
}