package com.example.appestudiantes.presentation.viewmodel

data class LoginUiState(
    val email: String ="",
    val password:String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
