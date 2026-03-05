package com.example.firstandroidapp.ui.first

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FirstViewModel: ViewModel() {
    var text by mutableStateOf("")
        private set

    fun onTextFieldChanged(value: String) {
        text = value
    }

    fun clearTextField() {
        text = ""
    }
}