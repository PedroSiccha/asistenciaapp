package com.inforad.asistenciaapp.presentation.view.admin.asistencia.noverificar

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.noverificar.components.AdminAsistenciaNoVerificarContent

@Composable
fun AdminAsistenciaNoVerificarView(navController: NavHostController = rememberNavController()) {
    Scaffold() { paddingValues ->
        AdminAsistenciaNoVerificarContent(paddingValues = paddingValues, navController = navController)
    }
}