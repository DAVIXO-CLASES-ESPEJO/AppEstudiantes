package com.example.appestudiantes.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun CustomInput(
    // texto dentro del input
    value: String,
    // fun que cambia cada vez que se escribe algo dentro del input
    onValueChanged:(String) -> Unit,
    // titulo flotante
    label:String,
    // modificador opcional externo
    modifier: Modifier = Modifier,
    // tipo de teclado en el dispositivo
    keyboardType: KeyboardType = KeyboardType.Text,
    // efecto visual que oculta el password
    visualTransformation: VisualTransformation = VisualTransformation.None,
    // input de una sola linea
    singleLine: Boolean = true,
    // recibir un icono al final del input
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = {Text(label)},
        singleLine = singleLine,
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        //trailingIcon = trailingIcon,
        modifier = modifier.fillMaxWidth()
    )
}