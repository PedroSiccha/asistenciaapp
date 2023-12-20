package com.inforad.asistenciaapp.presentation.view.admin.asistencia.asismanual

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.asismanual.components.AdminAsistenciaManualContent
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.asismanual.components.AsistenciaManualComponent

@Composable
fun AdminAsistenciaManualView(navController: NavHostController = rememberNavController(), reunionParam: String) {
    Scaffold() { paddingValues ->
        AdminAsistenciaManualContent(paddingValues = paddingValues, navController = navController)
    }
    AsistenciaManualComponent(navController = navController)
}