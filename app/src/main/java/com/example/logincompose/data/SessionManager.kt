package com.example.logincompose.data

import android.content.Context
import androidx.core.content.edit

/**
 * Clase encargada de gestionar la persistencia de la sesión del usuario
 * utilizando SharedPreferences.
 */
class SessionManager(context: Context) {

    // Archivo de preferencias donde se guardará el estado de la sesión
    private val prefs = context.getSharedPreferences("session", Context.MODE_PRIVATE)

    /**
     * Guarda el estado de inicio de sesión como 'true'.
     */
    fun saveLogin() {
        prefs.edit {
            putBoolean("logged", true)
        }
    }

    /**
     * Limpia los datos de la sesión (logout).
     */
    fun logout() {
        prefs.edit {
            clear()
        }
    }

    /**
     * Verifica si el usuario tiene una sesión activa.
     * @return true si el usuario está logueado, false en caso contrario.
     */
    fun isLogged(): Boolean {
        return prefs.getBoolean("logged", false)
    }
}
