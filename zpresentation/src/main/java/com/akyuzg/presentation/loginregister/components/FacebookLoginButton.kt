package com.akyuzg.presentation.loginregister.components

import androidx.compose.runtime.Composable
import com.akyuzg.presentation.theme.FacebookColor
import com.akyuzg.presentation.theme.White
import com.path.presentation.R


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