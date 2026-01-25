package com.example.logincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.logincompose.navigation.AppNavGraph
import com.example.logincompose.data.SessionManager

/**
 * Actividad principal de la aplicación.
 * Actúa como el punto de entrada único y contenedor de la interfaz de Compose.
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Habilita el diseño de borde a borde (edge-to-edge)
        enableEdgeToEdge()

        // Inicialización del gestor de sesiones con el contexto de la actividad
        val sessionManager = SessionManager(this)

        // Define el contenido de la interfaz de usuario con Jetpack Compose
        setContent {
            MaterialTheme {
                // Scaffold proporciona la estructura básica de Material Design (como soporte para barras de sistema)
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Surface es el contenedor base que aplica el color de fondo del tema
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        // Carga el grafo de navegación que decide qué pantalla mostrar
                        AppNavGraph(sessionManager = sessionManager)
                    }
                }
            }
        }
    }
}
