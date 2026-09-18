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


    fun onLoginClick(){
        //TODO logica de click
    }
}