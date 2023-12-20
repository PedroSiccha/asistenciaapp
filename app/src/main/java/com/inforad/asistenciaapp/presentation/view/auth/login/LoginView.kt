package com.inforad.asistenciaapp.presentation.view.auth.login

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.inforad.asistenciaapp.presentation.ui.theme.AsistenciaAppTheme
import com.inforad.asistenciaapp.presentation.view.auth.login.components.Login
import com.inforad.asistenciaapp.presentation.view.auth.login.components.LoginContent

@Composable
fun LoginView(navController: NavHostController) {
    Scaffold{
            paddingValues ->
        LoginContent(navController, paddingValues)
    }
    Login(navController = navController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginViewPreview() {
    AsistenciaAppTheme {
        LoginView(rememberNavController())
    }
}