# LoginComposeApp

Una aplicación de Android moderna construida con **Jetpack Compose** que implementa un flujo básico de autenticación y gestión de sesiones.

## 🚀 Características

- **Jetpack Compose**: Interfaz de usuario declarativa y moderna.
- **Navegación**: Uso de `Compose Navigation` para gestionar el flujo entre pantallas.
- **Gestión de Sesiones**: Persistencia local del estado de autenticación mediante `SharedPreferences`.
- **Material 3**: Implementación de componentes y temas basados en la última versión de Material Design.
- **Arquitectura Limpia**: Separación de responsabilidades entre navegación, datos y UI.

## 🛠️ Tecnologías Utilizadas

- **Kotlin**: Lenguaje de programación principal.
- **Jetpack Compose**: Toolkit moderno para construir UI nativa.
- **Compose Navigation**: Navegación entre componentes Composable.
- **SharedPreferences**: Almacenamiento persistente de datos simples (estado de sesión).

## 📂 Estructura del Proyecto

- `ui/`: Contiene las pantallas de la aplicación (`LoginScreen`, `HomeScreen`).
- `navigation/`: Define el grafo de navegación (`AppNavGraph`) y las rutas.
- `data/`: Gestión de datos y persistencia (`SessionManager`).
- `MainActivity.kt`: Punto de entrada de la aplicación y configuración del host de Compose.

## 📋 Requisitos

- Android Studio Flamingo o superior.
- JDK 17.
- Dispositivo Android o Emulador con API 24 o superior.

## 🔧 Instalación

1. Clona este repositorio.
2. Abre el proyecto en Android Studio.
3. Sincroniza el proyecto con los archivos Gradle.
4. Ejecuta la aplicación en tu dispositivo o emulador.
