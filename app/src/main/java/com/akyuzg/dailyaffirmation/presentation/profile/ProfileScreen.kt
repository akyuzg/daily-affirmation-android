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
import com.akyuzg.dailyaffirmation.R
import com.akyuzg.dailyaffirmation.ui.theme.MenuIconBgGray
import com.akyuzg.dailyaffirmation.ui.theme.MenuIconGray
import com.akyuzg.dailyaffirmation.ui.theme.Orange
import com.akyuzg.dailyaffirmation.ui.theme.OrangeLight

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
            ScreenSpacer()
            MenuContainer {
                MenuItemView(text = "Favorilerim", iconId = R.drawable.ic_heart_outlined)
                MenuSeparator()
                MenuItemView(text = "Koleksiyonlarım",  iconId = R.drawable.ic_bookmark_outlined)
                MenuSeparator()
                MenuItemView(text = "Olumlamalarım", iconId = R.drawable.ic_smile_outlined)
            }
            MenuContainer {
                MenuItemView(text = "Hatırlatıcılar", iconId = R.drawable.ic_notification_outlined, iconColor = Orange, iconBackgroundColor = OrangeLight)
            }
            MenuContainer {
                MenuItemView(text = "Kategoriler", iconId = R.drawable.ic_category_outlined)
                MenuSeparator()
                MenuItemView(text = "Arkaplan", iconId = R.drawable.ic_paint_outlined)
                MenuSeparator()
                MenuItemView(text = "Ayarlar", iconId = R.drawable.ic_setting_outlined, iconColor = MenuIconGray, iconBackgroundColor = MenuIconBgGray)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController())
}