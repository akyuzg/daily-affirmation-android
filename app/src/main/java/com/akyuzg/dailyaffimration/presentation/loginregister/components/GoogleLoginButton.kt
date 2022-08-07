package com.akyuzg.dailyaffimration.presentation.loginregister.components

import androidx.compose.runtime.Composable
import com.akyuzg.dailyaffimration.presentation.theme.White
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