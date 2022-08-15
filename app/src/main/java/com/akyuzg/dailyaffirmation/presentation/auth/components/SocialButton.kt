package com.akyuzg.dailyaffirmation.presentation.auth.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akyuzg.dailyaffirmation.presentation.theme.FacebookColor
import com.akyuzg.dailyaffirmation.presentation.theme.Grey10
import com.akyuzg.dailyaffirmation.R

@Composable
fun SocialButton(
    onClick: () -> Unit,
    text: String,
    @DrawableRes iconId: Int,
    backgroundColor: Color,
    textColor: Color = Grey10
){
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
        ),
        shape = RoundedCornerShape(20.dp),
    ) {
        Box(modifier = Modifier.height(24.dp).width(24.dp)) {
            Image(
                modifier =Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                painter = painterResource(id = iconId) ,
                contentDescription = ""
            )
        }
        Text(
            fontSize = 14.sp,
            text = text,
            color = textColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(vertical = 2.dp)),
            textAlign = TextAlign.Center
        )
    }
}


@Preview
@Composable
fun SocialButtonPreview(){
    SocialButton(
        onClick = {},
        text = "Facebook",
        backgroundColor = FacebookColor,
        iconId = R.drawable.close
    )
}