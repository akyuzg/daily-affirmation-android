package com.akyuzg.dailyaffirmation.presentation.auth.components

import androidx.compose.runtime.Composable
import com.akyuzg.dailyaffirmation.presentation.theme.White
import com.akyuzg.dailyaffirmation.R


@Composable
fun GoogleLoginButton(onClick: () -> Unit){
    SocialButton(
        onClick = onClick,
        text = "Google",
        backgroundColor = White,
        iconId = R.drawable.ic_google
    )
}