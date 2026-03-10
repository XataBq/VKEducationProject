package com.example.firstandroidapp.ui.first

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class FirstViewModel: ViewModel() {

    private val _events = MutableSharedFlow<UiEvent>(
        replay = 0,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val events = _events.asSharedFlow()

    var text by mutableStateOf("")
        private set

    fun onTextFieldChanged(value: String) {
        text = value
    }

    fun clearTextField() {
        text = ""
    }
    //Отправка события
    private fun sendEvent(event: UiEvent){
        viewModelScope.launch {
            _events.emit(event)
        }
    }
    //Валидация номера и отправка события по решению валидации
    fun onCallClick () {
        if (!phoneNumberValidation(this.text)) {
            //Номер не содержит цифр
            sendEvent(UiEvent.ShowSnackbar("Неверный формат номера!"))
        }
        else {
            //Убрал все лишнии символы, оставив только цифры и "+, *, #"
            val correctedNumber = correctPhoneNumberInput(this.text)
            sendEvent(UiEvent.OpenDialer(correctedNumber))
        }
    }

    fun onShareClick(){
        sendEvent(UiEvent.ShareData)
    }
}