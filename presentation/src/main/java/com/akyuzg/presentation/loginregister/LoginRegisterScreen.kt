package com.akyuzg.presentation.loginregister

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.akyuzg.presentation.components.LogoWithText
import com.akyuzg.presentation.components.WelcomeText

@Composable
fun LoginRegisterScreen(navController: NavController) {
    Column {
        Text(text = "X")
        LogoWithText()
        WelcomeText()
    }
}


@Preview(showBackground = true)
@Composable
fun LoginRegisterScreenPreview() {
    LoginRegisterScreen(rememberNavController())
}