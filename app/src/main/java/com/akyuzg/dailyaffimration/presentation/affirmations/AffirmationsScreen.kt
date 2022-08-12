package com.akyuzg.dailyaffimration.presentation.affirmations

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.akyuzg.dailyaffimration.domain.model.Affirmation
import com.akyuzg.dailyaffimration.presentation.components.AffirmationViewSingleton
import com.akyuzg.dailyaffimration.presentation.components.AffirmationView
import com.akyuzg.dailyaffimration.presentation.components.BackgroundImage
import com.akyuzg.dailyaffimration.presentation.theme.White
import com.akyuzg.dailyaffirmation.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager


fun getVisibleAffirmation(state: AffirmationsState): Affirmation {
    return state.affirmations[state.visibleIndex]
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AffirmationsScreen(
    navController: NavController,
    vm: AffirmationsViewModel = hiltViewModel()
) {
    val state = vm.state.value

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {

        BackgroundImage(id = R.drawable.initial_affirmation_bg)
        LoadingIndicator(state = state)
        Error(state)

        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            HeadMenu()
            AffirmationPager(state, vm)
        }

    }

}

@Composable
fun Error(state: AffirmationsState) {
    if(state.error.isNotEmpty()){
        Text(
            color = White,
            text = state.error,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
    }
}


@Composable
fun LoadingIndicator(state: AffirmationsState) {
    if(state.isLoading){
        CircularProgressIndicator(
            color = White,
            strokeWidth = 3.dp
        )
    }
}

@ExperimentalPagerApi
@Composable
fun AffirmationPager(
    state: AffirmationsState,
    vm: AffirmationsViewModel
) {
    if(state.affirmations.isNotEmpty()){
        HorizontalPager(
            modifier = Modifier
                .fillMaxSize(),
            count = state.affirmations.size
        ) { page ->
            val affirmation = state.affirmations[page]
            AffirmationView(
                affirmation = affirmation,
                onLikeClicked = { selected ->
                    vm.onEvent(AffirmationEvent.LikeChanged(affirmation, selected))
                },
                onBookmarkClicked = { selected ->
                    vm.onEvent(AffirmationEvent.BookmarkChanged(affirmation, selected))
                }
            )
        }
    }else{
        AffirmationViewSingleton()
    }
}

@Composable
fun HeadMenu() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ){

    }
}




