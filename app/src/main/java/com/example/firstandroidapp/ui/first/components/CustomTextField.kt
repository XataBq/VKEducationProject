package com.example.firstandroidapp.ui.first.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.firstandroidapp.R

@Composable
fun CustomTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    onClearClick: () -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue -> onValueChanged(newValue) },
        label = {
            Text(
                text = stringResource(R.string.text_field_label)
            )
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(0.7F)
            .padding(vertical = 15.dp),
        shape = RoundedCornerShape(13.dp),
        trailingIcon = {
            IconButton(
                onClick = onClearClick
            ) {
                Icon(
                    Icons.Default.Clear,
                    contentDescription = stringResource(R.string.content_description_clear)
                )
            }
        }
    )
}