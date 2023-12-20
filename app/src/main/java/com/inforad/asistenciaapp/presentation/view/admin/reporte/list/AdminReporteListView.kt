package com.inforad.asistenciaapp.presentation.view.admin.reporte.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.presentation.components.DefaultTopBar
import com.inforad.asistenciaapp.presentation.view.admin.reporte.list.components.AdminReporte
import com.inforad.asistenciaapp.presentation.view.admin.reporte.list.components.AdminReporteListContent

@Composable
fun AdminReporteListView(navController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Reportes",
                navController = navController,
                upAvailable = true
            )
        }
    ) { paddingValues ->
        AdminReporteListContent(navController = navController, paddingValues = paddingValues)
    }
    AdminReporte(navController = navController)
}