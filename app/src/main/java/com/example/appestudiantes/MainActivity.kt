package com.example.appestudiantes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appestudiantes.presentation.navigation.AppNavigation
import com.example.appestudiantes.presentation.theme.AppEstudiantesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppEstudiantesTheme {
                AppNavigation()
            }
        }
    }
}
