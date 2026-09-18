package com.example.appestudiantes.presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appestudiantes.presentation.components.CustomInput
import com.example.appestudiantes.presentation.components.PrimaryButton
import com.example.appestudiantes.presentation.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    // datos por defecto del viewmodel
    viewModel: LoginViewModel = viewModel(),
    onNavigateToRegister: () -> Unit
){
    // valores actuales del viewmodel
    val state = viewModel.uiState
    // valores propios de la pantalla login
    var isVisible by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }
    // generar animacion de entrada
    LaunchedEffect(Unit) {
        isVisible = true
    }

    // contenedor principal
    Surface(
        // indica al surface ocupe todo el alto y el ancho posible
        modifier = Modifier.fillMaxSize(),
        // color de fondo tema del celular
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                // input metod qeu detecta al teclado y reordena la interfaz
                .imePadding()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn() + slideInVertically(
                    initialOffsetY = {it /2}
                )
            ) {
                // componentes visuales para el login
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // texto principal de bienvenida
                    Text(
                        text = "Portal Estudiantil",
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp
                        ),
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // texto secundario
                    Text(
                        text = "Inicia sesión para continuar",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(36.dp))

                    CustomInput(
                        value = state.email,
                        onValueChanged = {viewModel.onEmailChanged(it)},
                        label = "Correo del estudiante",
                        keyboardType = KeyboardType.Email
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomInput(
                        value = state.password,
                        onValueChanged = {
                            newPassword ->
                            viewModel.onPasswordChanged(newPassword)
                        },
                        label = "Contraseña",
                        keyboardType = KeyboardType.Password,
                        // visualTransformation =
                    )

                    // estructrura condicional si el viewmodel habilita el mensaje de error
                    if(state.errorMessage != null){
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = state.errorMessage,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                    Spacer(modifier = Modifier.height(28.dp))

                    PrimaryButton(
                        text = "Ingresar",
                        onClick = {viewModel.onLoginClick()},
                        isLoading = state.isLoading
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // text personalizado que lñleva al registro
                    TextButton(
                        onClick = onNavigateToRegister
                    ) {
                        Text(
                            text = "¿No tienes cuenta? Registrate aqui",
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }


                }
            }
        }
    }
}