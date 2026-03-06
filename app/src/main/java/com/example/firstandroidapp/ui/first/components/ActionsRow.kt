package com.example.firstandroidapp.ui.first.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.firstandroidapp.R

@Composable
fun ActionsRow(
    navigateSecondActivity: () -> Unit,
    shareData: () -> Unit,
    phoneCall: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.8F),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Button(
            onClick = navigateSecondActivity,
            modifier = Modifier
                .height(48.dp)
                .weight(1F),
            shape = RoundedCornerShape(12.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            Text(text = stringResource(R.string.second_activity))
        }
        FilledIconButton(
            onClick = shareData,
            modifier = Modifier.size(48.dp),
            shape = RoundedCornerShape(14.dp),
        ) {
            Icon(
                Icons.Default.Share,
                contentDescription = stringResource(R.string.content_description_share)
            )
        }
        FilledIconButton(
            onClick = phoneCall,
            modifier = Modifier.size(48.dp),
            shape = RoundedCornerShape(14.dp),
        ) {
            Icon(
                Icons.Default.Call,
                contentDescription = stringResource(R.string.content_description_call)
            )
        }
    }
}