package com.akyuzg.dailyaffimration.presentation.affirmation_stack

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.akyuzg.dailyaffimration.presentation.components.BackgroundImage
import androidx.hilt.navigation.compose.hiltViewModel
import com.akyuzg.dailyaffimration.presentation.components.AffirmationItem
import com.akyuzg.dailyaffimration.presentation.components.AffirmationItemSingleton
import com.akyuzg.dailyaffimration.presentation.theme.IconButtonBackgroundColor
import com.akyuzg.dailyaffimration.presentation.theme.White
import com.akyuzg.dailyaffirmation.R


@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
    ) {

        BackgroundImage(id = R.drawable.initial_affirmation_bg)
        LoadingIndicator(state = state, modifier = Modifier.align(Alignment.Center))

        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            HearderMenu()
            AffirmationStack(state)
        }

    }

}



@Composable
fun LoadingIndicator(state: AffirmationStackState, modifier: Modifier) {
    if(state.isLoading){
        CircularProgressIndicator(
            modifier = modifier,
            color = White,
            strokeWidth = 3.dp
        )
    }
}

@Composable
fun AffirmationStack(state: AffirmationStackState) {
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if(state.affirmations.isNotEmpty()){
            AffirmationItem(
                affirmation = state.affirmations[0],
            )
        }else{
            AffirmationItemSingleton()
        }

    }

}

@Composable
fun HearderMenu() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ){

    }
}

@Composable
fun RoundedIconButton(
    onClick: (selected: Boolean) -> Unit,
    @DrawableRes id: Int = R.drawable.ic_bookmark
) {
    var selected by remember { mutableStateOf(false) }

    val buttonSize = 48.dp
        Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16))
            .width(buttonSize)
            .height(buttonSize)
            .background(color = IconButtonBackgroundColor)
            .clickable {
                selected = !selected
                onClick(selected)
                       },
            contentAlignment = Alignment.Center,
    ) {

            Icon(
                painter = painterResource(id = id),
                contentDescription = null,
                tint = Color.Unspecified
            )
    }
}


