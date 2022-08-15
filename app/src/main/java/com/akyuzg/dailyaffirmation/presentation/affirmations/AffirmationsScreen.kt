package com.akyuzg.dailyaffirmation.presentation.affirmations

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.akyuzg.dailyaffirmation.domain.model.Affirmation
import com.akyuzg.dailyaffirmation.presentation.components.Page
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
        AffirmationPager(state, vm,
            onBookmarkClicked = { affirmation ->
                vm.onEvent(AffirmationEvent.BookmarkChanged(affirmation))
            },
            onLikeClicked = { affirmation ->
                vm.onEvent(AffirmationEvent.LikeChanged(affirmation))
            }
        )
    }
}




@ExperimentalPagerApi
@Composable
fun AffirmationPager(
    state: AffirmationsState,
    vm: AffirmationsViewModel,
    onLikeClicked: ((affirmation: Affirmation) -> Unit)? = null,
    onBookmarkClicked: ((affirmation: Affirmation) -> Unit)? = null,
) {
    if(state.affirmations.isNotEmpty()){
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            count = state.affirmations.size
        ) { page ->
            val affirmation = state.affirmations[page]
            AffirmationView(
                affirmation = affirmation,
                onLikeClicked = { selected ->
                    affirmation.liked = selected
                    onLikeClicked?.apply {
                        onLikeClicked(affirmation)
                    }
                },
                onBookmarkClicked = { selected ->
                    affirmation.bookmarked = selected
                    onBookmarkClicked?.apply {
                        onBookmarkClicked(affirmation)
                    }
                }
            )
        }
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




