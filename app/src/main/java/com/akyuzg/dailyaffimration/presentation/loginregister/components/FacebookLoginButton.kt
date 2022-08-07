package com.akyuzg.dailyaffimration.presentation.loginregister.components

import androidx.compose.runtime.Composable
import com.akyuzg.dailyaffirmation.R
import com.akyuzg.dailyaffimration.presentation.theme.FacebookColor
import com.akyuzg.dailyaffimration.presentation.theme.White


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