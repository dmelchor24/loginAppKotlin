package com.example.logincompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.logincompose.data.SessionManager
import com.example.logincompose.ui.login.LoginScreen
import com.example.logincompose.ui.home.HomeScreen

/**
 * Grafo de navegación de la aplicación.
 * Define las rutas disponibles y gestiona la transición entre pantallas.
 * 
 * @param sessionManager Gestor de sesión para determinar el estado de autenticación.
 */
@Composable
fun AppNavGraph(sessionManager: SessionManager) {

    // Controlador de navegación que mantiene el estado de la pila de pantallas
    val navController = rememberNavController()
    
    // Determina la pantalla inicial basándose en si hay una sesión activa
    val startDestination = if (sessionManager.isLogged()) "home" else "login"

    // Host de navegación que vincula las rutas con sus respectivos Composables
    NavHost(navController = navController, startDestination = startDestination) {

        // Definición de la ruta para la pantalla de Login
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    // Al iniciar sesión, guardamos el estado y navegamos al Home
                    sessionManager.saveLogin()
                    navController.navigate("home") {
                        // Limpiamos la pila para que el usuario no pueda volver al login con el botón atrás
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }

        // Definición de la ruta para la pantalla de Inicio
        composable("home") {
            HomeScreen(
                onLogout = {
                    // Al cerrar sesión, limpiamos el estado y navegamos de vuelta al Login
                    sessionManager.logout()
                    navController.navigate("login") {
                        // Limpiamos la pila para evitar volver al home sin estar autenticado
                        popUpTo("home") { inclusive = true }
                    }
                }
            )
        }
    }
}
