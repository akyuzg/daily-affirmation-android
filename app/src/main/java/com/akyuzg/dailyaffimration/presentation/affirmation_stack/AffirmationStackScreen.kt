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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.akyuzg.dailyaffimration.presentation.components.BackgroundImage
import androidx.hilt.navigation.compose.hiltViewModel
import com.akyuzg.dailyaffimration.domain.model.Affirmation
import com.akyuzg.dailyaffimration.presentation.components.AffirmationItem
import com.akyuzg.dailyaffimration.presentation.components.AffirmationItemSingleton
import com.akyuzg.dailyaffimration.presentation.theme.IconButtonBackgroundColor
import com.akyuzg.dailyaffimration.presentation.theme.White
import com.akyuzg.dailyaffirmation.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager


fun getVisibleAffirmation(state: AffirmationStackState): Affirmation{
    return state.affirmations[state.visibleIndex]
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(
    navController: NavController,
    vm: AffirmationStackViewModel = hiltViewModel()
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
            AffirmationStack(state, vm)
        }

    }

}

@Composable
fun Error(state: AffirmationStackState) {
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
fun LoadingIndicator(state: AffirmationStackState) {
    if(state.isLoading){
        CircularProgressIndicator(
            color = White,
            strokeWidth = 3.dp
        )
    }
}

@ExperimentalPagerApi
@Composable
fun AffirmationStack(
    state: AffirmationStackState,
    vm: AffirmationStackViewModel
) {

    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if(state.affirmations.isNotEmpty()){
            HorizontalPager(count = state.affirmations.size) { page ->
                val affirmation = state.affirmations[page]
                AffirmationItem(
                    affirmation = affirmation,
                    onLikeClicked = { selected ->
                        vm.onEvent(AffirmationEvents.LikeChanged(affirmation, selected))
                    },
                    onBookmarkClicked = { selected ->
                        vm.onEvent(AffirmationEvents.BookmarkChanged(affirmation, selected))
                    }
                )
            }
        }else{
            AffirmationItemSingleton()
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

@Composable
fun RoundedIconButton(
    onClick: ((selected: Boolean) -> Unit)? = null,
    @DrawableRes id: Int = R.drawable.ic_bookmark_outlined,
    @DrawableRes selectedId: Int = R.drawable.ic_bookmark_filled
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
                onClick?.let { callback ->
                    callback(selected)
                }
            },
            contentAlignment = Alignment.Center,
    ) {

            Icon(
                painter = painterResource(id = if(selected) selectedId else id),
                contentDescription = null,
                tint = Color.Unspecified
            )
    }
}


