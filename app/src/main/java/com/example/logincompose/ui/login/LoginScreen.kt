package com.example.logincompose.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.logincompose.utils.TestTags

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .testTag("login_screen"),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // 🔹 Título
        Text(
            text = "App de Testing",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .testTag(TestTags.LOGIN_TITLE)
        )

        // 🔹 Email
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                errorMessage = null
            },
            label = { Text("Correo Electrónico") },
            placeholder = { Text("ejemplo@correo.com") },
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
            isError = errorMessage != null,
            modifier = Modifier
                .fillMaxWidth()
                .testTag(TestTags.EMAIL_INPUT),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 Password
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                errorMessage = null
            },
            label = { Text("Contraseña") },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña"
                    )
                }
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            isError = errorMessage != null,
            modifier = Modifier
                .fillMaxWidth()
                .testTag(TestTags.PASSWORD_INPUT),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true
        )

        // 🔹 Error
        if (errorMessage != null) {
            Text(
                text = errorMessage!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.Start)
                    .testTag(TestTags.ERROR_MESSAGE)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // 🔹 Login Button
        Button(
            onClick = {
                when {
                    email.isEmpty() || password.isEmpty() ->
                        errorMessage = "Por favor, completa todos los campos"

                    email == "admin@test.com" && password == "123456" ->
                        onLoginSuccess()

                    else ->
                        errorMessage = "Credenciales incorrectas. Intenta de nuevo."
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .testTag(TestTags.LOGIN_BUTTON),
            shape = MaterialTheme.shapes.medium
        ) {
            Text("Iniciar Sesión", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        }

        // 🔹 Forgot password
        TextButton(
            onClick = { },
            modifier = Modifier
                .padding(top = 16.dp)
                .testTag(TestTags.FORGOT_PASSWORD_BUTTON)
        ) {
            Text("¿Olvidaste tu contraseña?")
        }
    }
}
