package com.inforad.asistenciaapp.presentation.view.colaborador.reporte.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.presentation.components.DefaultTopBar
import com.inforad.asistenciaapp.presentation.view.colaborador.reporte.list.components.CollReporteListContent
import com.inforad.asistenciaapp.presentation.view.profile.info.components.ProfileContent

@Composable
fun CollReporteListView(navController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Reportes",
                navController = navController,
                upAvailable = true
            )
        }
    ) { paddingValues ->
        CollReporteListContent(paddingValues = paddingValues)
    }
}