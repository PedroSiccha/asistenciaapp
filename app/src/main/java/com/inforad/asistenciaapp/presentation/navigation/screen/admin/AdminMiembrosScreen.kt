package com.inforad.asistenciaapp.presentation.navigation.screen.admin

import com.inforad.asistenciaapp.domain.model.Reunion

sealed class AdminMiembrosScreen(val route: String) {
    object MiembroCreate: AdminMiembrosScreen("admin/miembro/create")
}
