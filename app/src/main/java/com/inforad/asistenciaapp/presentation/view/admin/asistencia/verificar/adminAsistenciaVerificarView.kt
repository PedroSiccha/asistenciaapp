package com.inforad.asistenciaapp.presentation.view.admin.asistencia.verificar

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.verificar.components.AdminAsistenciaVerificarContent

@Composable
fun AdminAsistenciaVerificarView(navController: NavHostController = rememberNavController()) {
    Scaffold() { paddingValues ->
        AdminAsistenciaVerificarContent(paddingValues = paddingValues, navController = navController)
    }
}