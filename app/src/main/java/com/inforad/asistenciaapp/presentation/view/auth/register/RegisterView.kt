package com.inforad.asistenciaapp.presentation.view.auth.register

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.inforad.asistenciaapp.presentation.components.DefaultTopBar
import com.inforad.asistenciaapp.presentation.ui.theme.AsistenciaAppTheme
import com.inforad.asistenciaapp.presentation.view.auth.register.components.Register
import com.inforad.asistenciaapp.presentation.view.auth.register.components.RegisterContent
import com.inforad.asistenciaapp.presentation.view.auth.register.components.RegisterImg

@Composable
fun RegisterView(navController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(title = "REGISTRAR MIEMBRO", upAvailable = true, navController = navController)
        }
    ) { paddingValues ->
        RegisterContent(paddingValues = paddingValues)
    }
    Register(navController)
    RegisterImg(navController = navController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterViewPreview() {
    AsistenciaAppTheme {
        RegisterView(rememberNavController())
    }
}