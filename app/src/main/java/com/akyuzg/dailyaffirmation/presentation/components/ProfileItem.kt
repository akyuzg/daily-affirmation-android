package com.akyuzg.dailyaffirmation.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.akyuzg.dailyaffirmation.R

@Composable
fun ProfileItem(imageUrl: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        val photoSize = 54.dp
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .width(photoSize)
                .height(photoSize)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                color = MaterialTheme.colorScheme.onBackground,
                text = stringResource(R.string.user_name_and_surname_placeholder),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
            )
            Text(
                color = MaterialTheme.colorScheme.onBackground,
                text = stringResource(R.string.welcome),
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
            )
        }
    }

}