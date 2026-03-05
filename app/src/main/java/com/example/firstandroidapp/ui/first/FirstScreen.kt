package com.example.firstandroidapp.ui.first

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firstandroidapp.EXTRA_TEXT
import com.example.firstandroidapp.SecondActivity
import com.example.firstandroidapp.ui.first.components.ActionsRow
import com.example.firstandroidapp.ui.first.components.CustomTextField

@Composable
fun FirstScreen(
    firstViewModel: FirstViewModel = viewModel(),

) {
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures { focusManager.clearFocus() }
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomTextField(
            value = firstViewModel.text,
            onValueChanged = { newValue -> firstViewModel.onTextFieldChanged(newValue) },
            onClearClick = firstViewModel::clearTextField,
        )
        ActionsRow(
            navigateSecondActivity = { navigateSecondActivity(context, firstViewModel.text) },
            shareData = {},
            callNumber = {},
        )
    }
}

fun navigateSecondActivity(context: Context, data: String) {
    val intent = Intent(context, SecondActivity::class.java)
    intent.putExtra(EXTRA_TEXT, data)
    context.startActivity(intent)
}