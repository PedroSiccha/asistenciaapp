package com.inforad.asistenciaapp.presentation.navigation.screen.coll

import com.inforad.asistenciaapp.domain.model.Reunion

sealed class CollReporteScreen(val route: String) {
    object collReporteView: CollReporteScreen("coll/reporte/view")
}
