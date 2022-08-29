package com.akyuzg.dailyaffirmation.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.akyuzg.dailyaffirmation.R
import com.akyuzg.dailyaffirmation.ui.theme.MenuIconBackgroundColor

val MenuItemSpace = 12.dp

@Composable
fun MenuSeparator(){
    Box(
        modifier = Modifier
        .padding(start = MenuItemSpace)
        .fillMaxWidth()
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .height(1.dp)
        )
    }

}

@Composable
fun MenuContainer(
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colorScheme.background)
    ) {
        content()
    }
}



@Composable
fun MenuItem(
    text: String
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MenuItemSpace)
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(MenuIconBackgroundColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_right_arrow),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.size(24.dp)
            )
        }
        Text(
            text = text,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 8.dp)
                .width(IntrinsicSize.Max)
                .weight(1f)

        )
        Icon(
            painter = painterResource(id = R.drawable.ic_right_arrow),
            contentDescription = null,
            tint = Color.Unspecified,
        )

    }

}