package com.akyuzg.dailyaffimration.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.akyuzg.dailyaffimration.domain.model.Affirmation
import com.akyuzg.dailyaffimration.presentation.affirmation_stack.MainScreen
import com.akyuzg.dailyaffimration.presentation.theme.White

@Composable
fun AffirmationItem(
    affirmation: Affirmation
) {

    Box(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max)) {
        Text(
            color = White,
            text = "The passion I have for my work enables me to create real value.",
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 38.sp,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
    }

}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun AffirmationItemPreview() {
    AffirmationItem(
        affirmation = Affirmation(
            id = 1,
            text = "The passion I have for my work enables me to create real value.",
            categoryId = 1
        )
    )
}