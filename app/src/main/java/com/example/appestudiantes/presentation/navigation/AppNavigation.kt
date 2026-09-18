package com.example.appestudiantes.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appestudiantes.presentation.screens.LoginScreen
import com.example.appestudiantes.presentation.screens.RegisterScreen

@Composable
fun AppNavigation(){

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppRoutes.Login
    ){
        composable<AppRoutes.Login>{
            LoginScreen(onNavigateToRegister = {
                navController.navigate(AppRoutes.Register)
            })
        }

        composable<AppRoutes.Register>{
            RegisterScreen(
                onNavigateBackToLogin = {
                    navController.popBackStack()
                }
            )
        }
    }
}