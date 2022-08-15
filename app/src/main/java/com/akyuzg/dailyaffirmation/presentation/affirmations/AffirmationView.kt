package com.akyuzg.dailyaffirmation.presentation.affirmations

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akyuzg.dailyaffirmation.domain.model.Affirmation
import com.akyuzg.dailyaffirmation.presentation.theme.IconButtonBackgroundColor
import com.akyuzg.dailyaffirmation.presentation.theme.White
import com.akyuzg.dailyaffirmation.R


@Composable
fun AffirmationView(
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
            bookmarked = affirmation.bookmarked,
            liked = affirmation.liked,
            onBookmarkClicked = onBookmarkClicked,
            onLikeClicked = onLikeClicked
        )
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
            id = R.drawable.ic_heart_outlined,
            selectedId = R.drawable.ic_heart_filled,
            selected = liked
        )
        Spacer(Modifier.width(spaceX))
        RoundedIconButton(
            onClick = onBookmarkClicked,
            id = R.drawable.ic_bookmark_outlined,
            selectedId = R.drawable.ic_bookmark_filled,
            selected = bookmarked
        )
    }
}


@Composable
fun RoundedIconButton(
    onClick: ((selected: Boolean) -> Unit)? = null,
    @DrawableRes id: Int = R.drawable.ic_bookmark_outlined,
    @DrawableRes selectedId: Int = R.drawable.ic_bookmark_filled,
    selected: Boolean
) {
    var selectedState by remember { mutableStateOf(selected) }

    val buttonSize = 48.dp
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16))
            .width(buttonSize)
            .height(buttonSize)
            .background(color = IconButtonBackgroundColor)
            .clickable {
                selectedState = !selectedState
                onClick?.let { callback ->
                    callback(selectedState)
                }
            },
        contentAlignment = Alignment.Center,
    ) {

        Icon(
            painter = painterResource(id = if(selectedState) selectedId else id),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun AffirmationItemPreview() {
    AffirmationView(
        affirmation = Affirmation(
            id = 1,
            text = "The passion I have for my work enables me to create real value.",
            categoryId = 1
        )
    )
}