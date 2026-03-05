package com.example.firstandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import com.example.firstandroidapp.ui.first.FirstScreen
import com.example.firstandroidapp.ui.theme.FirstAndroidAppTheme

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAndroidAppTheme {
                Scaffold { innerPadding ->
                    FirstScreen(innerPaddingValues = innerPadding)
                }
            }
        }
    }
}