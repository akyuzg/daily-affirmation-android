package com.akyuzg.dailyaffimration.presentation.affirmations

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.akyuzg.dailyaffimration.presentation.components.Page
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager


@OptIn(ExperimentalPagerApi::class)
@Composable
fun AffirmationsScreen(
    navController: NavController,
    vm: AffirmationsViewModel = hiltViewModel()
) {
    val state = vm.state.value

    Page(
        loading = state.isLoading,
        error = state.error
    ){
        HeadMenu()
        AffirmationPager(state, vm)
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




