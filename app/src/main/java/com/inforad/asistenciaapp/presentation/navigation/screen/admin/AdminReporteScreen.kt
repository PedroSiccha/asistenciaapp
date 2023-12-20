package com.inforad.asistenciaapp.presentation.navigation.screen.admin

import com.inforad.asistenciaapp.domain.model.Reunion

sealed class AdminReporteScreen(val route: String) {
    object ReporteView: AdminReporteScreen("admin/reporte/view")
}
