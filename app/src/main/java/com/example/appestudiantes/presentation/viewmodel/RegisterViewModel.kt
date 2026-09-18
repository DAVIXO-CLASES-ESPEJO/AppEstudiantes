package com.example.appestudiantes.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegisterViewModel: ViewModel() {
    var uiState by mutableStateOf(RegisterUiState())
    private set

    // metodos para actualizar los campos individualmente
    fun onIdEstudianteChanged(newIdEstudiante: String ){
        uiState = uiState.copy(idEstudiante = newIdEstudiante, errorMessage = null)
    }
    fun onNombresChanged(newNombres: String ){
        uiState = uiState.copy(nombres = newNombres, errorMessage = null)
    }
    fun onApellidosChanged(newApellidos: String ){
        uiState = uiState.copy(apellidos = newApellidos, errorMessage = null)
    }
    fun onEmailChanged(newEmail: String){
        uiState = uiState.copy(email = newEmail, errorMessage = null)
    }
    fun onPasswordChanged(newPassword: String ){
        uiState = uiState.copy(password = newPassword, errorMessage = null)
    }
    fun onRegisterClick(){
        // validaciones
        if (uiState.idEstudiante.isBlank() || uiState.nombres.isBlank() ||
            uiState.apellidos.isBlank() ||
            uiState.email.isBlank() || uiState.password.isBlank()){
            uiState = uiState.copy(errorMessage = "Por favor, completa todos los datos")
            return
        }
        if(!uiState.email.contains("@") || !uiState.email.contains(".")){
            uiState = uiState.copy(errorMessage = "El correo electronico debe ser válido(ej. correo@dominio.com)")
            return
        }
        val passwordRegEx = "".toRegex()
        if(!uiState.password.matches(passwordRegEx)){
            uiState = uiState.copy(
                errorMessage = "La contraseña debe tener al menos 8 caracteres, una mayúscula, un número y un símbolo.")
            return
        }

        uiState = uiState.copy(isLoading = true, errorMessage = null)
    }
}