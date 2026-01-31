// Archivo de construcción de nivel superior donde se pueden agregar opciones de configuración comunes a todos los subproyectos/módulos.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
}