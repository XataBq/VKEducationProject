package com.example.firstandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.firstandroidapp.ui.second.SecondScreen
import com.example.firstandroidapp.ui.theme.FirstAndroidAppTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAndroidAppTheme {
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                    SecondScreen(
                        innerPadding = innerPadding,
                        stringData = intent.getStringExtra(EXTRA_TEXT).orEmpty()
                    )
                }
            }
        }
    }
}