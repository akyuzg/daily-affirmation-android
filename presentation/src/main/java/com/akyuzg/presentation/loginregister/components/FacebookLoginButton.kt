package com.akyuzg.presentation.loginregister.components

import androidx.compose.runtime.Composable
import com.akyuzg.presentation.theme.Facebook
import com.akyuzg.presentation.theme.White


@Composable
fun FacebookLoginButton(){
    SocialButton(
        text = "Facebook",
        backgroundColor = Facebook,
        textColor = White
    )
}