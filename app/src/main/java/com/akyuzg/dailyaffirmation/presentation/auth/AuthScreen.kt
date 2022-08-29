package com.akyuzg.dailyaffirmation.presentation.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.akyuzg.dailyaffirmation.presentation.components.*
import com.akyuzg.dailyaffirmation.presentation.auth.components.FacebookLoginButton
import com.akyuzg.dailyaffirmation.presentation.auth.components.GoogleLoginButton
import com.akyuzg.dailyaffirmation.ui.theme.White
import com.akyuzg.dailyaffirmation.R

@Composable
fun AuthScreen(navController: NavController) {
    val padding = 10.dp
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        BackgroundImage()
        StaticIcon(id = R.drawable.close, color = White)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            LogoWithText()
            WelcomeText()
            Column(modifier = Modifier.padding(24.dp)) {
                GoogleLoginButton(onClick = {})
                Spacer(Modifier.size(padding))
                FacebookLoginButton(onClick = {})

            }
            Text(
                text = "üye olmadan devam et",
                color = White
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginRegisterScreenPreview() {
    AuthScreen(rememberNavController())
}