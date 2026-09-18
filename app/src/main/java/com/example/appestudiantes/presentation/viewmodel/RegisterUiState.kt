package com.example.appestudiantes.presentation.viewmodel

import android.os.Message

data class RegisterUiState(
    val idEstudiante: String = "",
    val nombres: String = "",
    val apellidos: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
