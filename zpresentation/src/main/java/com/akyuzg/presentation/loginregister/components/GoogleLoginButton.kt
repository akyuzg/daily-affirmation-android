package com.akyuzg.presentation.loginregister.components

import androidx.compose.runtime.Composable
import com.akyuzg.presentation.theme.*
import com.path.presentation.R


@Composable
fun GoogleLoginButton(onClick: () -> Unit){
    SocialButton(
        onClick = onClick,
        text = "Google",
        backgroundColor = White,
        iconId = R.drawable.ic_google
    )
}