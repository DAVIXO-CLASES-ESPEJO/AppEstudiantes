package com.example.appestudiantes.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface AppRoutes {
    @Serializable
    data object Login : AppRoutes

    @Serializable
    data object Register : AppRoutes
}