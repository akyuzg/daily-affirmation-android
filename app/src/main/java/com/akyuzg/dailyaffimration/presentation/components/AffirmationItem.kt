package com.akyuzg.dailyaffimration.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akyuzg.dailyaffimration.domain.model.Affirmation
import com.akyuzg.dailyaffimration.presentation.affirmation_stack.RoundedIconButton
import com.akyuzg.dailyaffimration.presentation.theme.White
import com.akyuzg.dailyaffirmation.R


@Composable
fun AffirmationItem(
    affirmation: Affirmation,
    onLikeClicked: ((selected: Boolean) -> Unit)? = null,
    onBookmarkClicked: ((selected: Boolean) -> Unit)? = null
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Min),

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentAlignment = Alignment.Center
        ){
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
        ActionButtons(
            bookmarked = false,
            liked = false,
            onBookmarkClicked = onBookmarkClicked,
            onLikeClicked = onLikeClicked
        )
    }
}
@Composable
fun AffirmationItemSingleton(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp + 48.dp)) {
    }
}


@Composable
fun ActionButtons(
    bookmarked: Boolean,
    liked: Boolean,
    onLikeClicked: ((selected: Boolean) -> Unit)? = null,
    onBookmarkClicked: ((selected: Boolean) -> Unit)? = null
){
    val spaceX = 16.dp
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxHeight()
            .fillMaxWidth()
    ) {

        RoundedIconButton(
            onClick = onLikeClicked,
            id = if(liked) R.drawable.ic_heart_filled else R.drawable.ic_heart_outlined,
            selectedId = R.drawable.ic_heart_filled
        )
        Spacer(Modifier.width(spaceX))
        RoundedIconButton(
            onClick = onBookmarkClicked,
            id = if(bookmarked) R.drawable.ic_bookmark_filled else R.drawable.ic_bookmark_outlined,
            selectedId = R.drawable.ic_bookmark_filled
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