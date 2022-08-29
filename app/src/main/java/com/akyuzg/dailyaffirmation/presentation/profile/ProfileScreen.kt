package com.akyuzg.dailyaffirmation.presentation.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.akyuzg.dailyaffirmation.presentation.components.*
import com.akyuzg.dailyaffirmation.presentation.profile.components.StartPremiumView

@Composable
fun ProfileScreen(navController: NavController) {
    Screen {
        ProfileItem(imageUrl =  "https://cdn-icons-png.flaticon.com/512/147/147144.png")
        ScreenSpacer()

        Column(modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
        ) {

            StartPremiumView()

            MenuContainer {
                MenuItem(text = "Favorilerim")
                MenuSeparator()
                MenuItem(text = "Koleksiyonlarım")
                MenuSeparator()
                MenuItem(text = "Olumlamalarım")
            }

            ScreenSpacer()

            MenuContainer {
                MenuItem(text = "Hatırlatıcılar")
            }

            ScreenSpacer()

            MenuContainer {
                MenuItem(text = "Kategoriler")
                MenuSeparator()
                MenuItem(text = "Arkaplan")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController())
}