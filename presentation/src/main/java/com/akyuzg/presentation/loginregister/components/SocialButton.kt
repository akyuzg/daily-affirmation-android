package com.akyuzg.presentation.loginregister.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akyuzg.presentation.theme.Facebook
import com.akyuzg.presentation.theme.Grey10

@Composable
fun SocialButton(
    text: String,
    backgroundColor: Color,
    textColor: Color = Grey10
){
    Button(
        onClick = {
            //your onclick code here
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
        ),
        shape = RoundedCornerShape(20.dp),
    ) {
        Text(
            text = text,
            color = textColor,
            modifier = Modifier.padding(PaddingValues(vertical = 2.dp))
        )
    }
}


@Preview
@Composable
fun SocialButtonPreview(){
    SocialButton("Facebook", Facebook)
}