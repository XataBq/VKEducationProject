package com.example.firstandroidapp.presentation.applist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.firstandroidapp.R

@Composable
fun AppListHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp)
            .padding(top = 48.dp, bottom = 32.dp, start = 24.dp, end = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Menu",
            modifier = Modifier.width(150.dp).height(48.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.weight(1F))
        FilledIconButton(
            onClick = {},
            modifier = Modifier
                .size(42.dp),
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = Color.White.copy(alpha = 0.15f),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_menu),
                contentDescription = "Menu"
            )
        }
    }
}