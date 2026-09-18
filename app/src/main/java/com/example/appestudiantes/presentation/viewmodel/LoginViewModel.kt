package com.example.appestudiantes.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var uiState by mutableStateOf(LoginUiState())
        private set
    fun onEmailChanged(newEmail: String){
        // se usa .copy() para mantener el estado anterior inmutable
        // reemplaza el email con el nuevo texto recibido
        uiState = uiState.copy(email = newEmail, errorMessage = null)
    }
    // completar password
    fun onPasswordChanged(newPassword: String ){
        uiState = uiState.copy(password = newPassword, errorMessage = null)
    }


    fun onLoginClick(){
        // 1 validar que los campos no esten vacios
        if (uiState.email.isBlank() || uiState.password.isBlank()){
            uiState = uiState.copy(errorMessage = "Por favor, completa todos los datos")
            return
        }
        // 2 validar el formato basico de correo, garantiza que el correo tenga @ y .
        if(!uiState.email.contains("@") || !uiState.email.contains(".")){
            uiState = uiState.copy(errorMessage = "El correo electronico debe ser válido(ej. correo@dominio.com)")
            return
        }
        // 3 si todo esta correcto
        uiState = uiState.copy(isLoading = true, errorMessage = null)
        // el camino va a la conexion con bd
    }
}