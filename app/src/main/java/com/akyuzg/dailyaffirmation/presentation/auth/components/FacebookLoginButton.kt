package com.akyuzg.dailyaffirmation.presentation.auth.components

import androidx.compose.runtime.Composable
import com.akyuzg.dailyaffirmation.R
import com.akyuzg.dailyaffirmation.ui.theme.FacebookColor
import com.akyuzg.dailyaffirmation.ui.theme.White


@Composable
fun FacebookLoginButton(onClick: () -> Unit){
    SocialButton(
        onClick = onClick,
        text = "Facebook",
        backgroundColor = FacebookColor,
        textColor = White,
        iconId = R.drawable.ic_facebook
    )
}