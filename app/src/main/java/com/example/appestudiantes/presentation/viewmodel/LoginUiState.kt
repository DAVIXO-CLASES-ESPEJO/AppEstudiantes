package com.example.appestudiantes.presentation.viewmodel

data class LoginUiState(
    // valores por defecto que carga la pantalla de la app
    val email: String ="",
    val password:String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
