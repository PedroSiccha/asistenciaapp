package com.inforad.asistenciaapp.presentation.view.roles

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.presentation.components.DefaultTopBar
import com.inforad.asistenciaapp.presentation.view.roles.components.RolesContent

@Composable
fun RolesView(navController: NavHostController) {
    Scaffold (
        topBar = {
            DefaultTopBar(
                title = "Selecciona un rol"
            )
        }
            ) { paddingValues ->
        RolesContent(paddingValues, navController)
    }
}