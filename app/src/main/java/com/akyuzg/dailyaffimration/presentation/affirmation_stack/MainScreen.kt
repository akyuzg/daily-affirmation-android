package com.akyuzg.dailyaffimration.presentation.affirmation_stack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.akyuzg.dailyaffimration.presentation.components.BackgroundImage
import androidx.hilt.navigation.compose.hiltViewModel
import com.akyuzg.dailyaffimration.presentation.components.AffirmationItem
import com.akyuzg.dailyaffimration.presentation.components.ErrorDialog
import com.akyuzg.dailyaffimration.presentation.theme.DailyAffirmationAppTheme
import com.akyuzg.dailyaffimration.presentation.theme.White


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

        BackgroundImage()
        ErrorUI(state)
        LoadingIndicator(state = state, modifier = Modifier.align(Alignment.Center))

        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            HearderMenu()
            AffirmationStack(state)
            BottomMenu()
        }

    }
}

@Composable
fun ErrorUI(state: AffirmationStackState) {
    if(state.error.isNotBlank()){
        ErrorDialog(state.message)
    }
    if(state.message.isNotBlank()){
        ErrorDialog(state.message)
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
    if(state.affirmations.isNotEmpty()){
        AffirmationItem(
            affirmation = state.affirmations[0],
        )
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
fun BottomMenu(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(
                color = Color.Gray,
            )
    ) {
        Row(modifier = Modifier
            .fillMaxHeight()
            .width(120.dp)
            .background(color = Color.Cyan)) {

        }
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = Color.Red)
        ) {

        }

    }
}


