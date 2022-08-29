package com.akyuzg.dailyaffirmation.presentation.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akyuzg.dailyaffirmation.R
import com.akyuzg.dailyaffirmation.ui.theme.White
import com.akyuzg.dailyaffirmation.ui.theme.purpleGradientEnd
import com.akyuzg.dailyaffirmation.ui.theme.purpleGradientStart

@Composable
fun StartPremiumView(){
    val purpleGradient = Brush.horizontalGradient(0f to purpleGradientStart, 1000f to purpleGradientEnd)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .background(purpleGradient)
            .padding(12.dp)
    ){
        Text(
            color = White,
            fontWeight = FontWeight.SemiBold,
            text = stringResource(id = R.string.upgrade_to_premium),
            fontSize = 16.sp)
        Text(
            color = White,
            fontWeight = FontWeight.Light,
            text = stringResource(id = R.string.upgrade_to_premium_description),
            fontSize = 14.sp)

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.defaultPadding)))

        Button(
            onClick = { /*TODO*/ },
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = White,
            ),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                fontSize = 14.sp,
                text = stringResource(id = R.string.start_now),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(PaddingValues(horizontal = 4.dp)),
                textAlign = TextAlign.Center
            )
        }
    }
}