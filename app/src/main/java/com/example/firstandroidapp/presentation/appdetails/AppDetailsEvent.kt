package com.example.firstandroidapp.presentation.appdetails

sealed interface AppDetailsEvent {
    data object UnderDevelopment : AppDetailsEvent
}