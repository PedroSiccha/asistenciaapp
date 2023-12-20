package com.inforad.asistenciaapp.presentation.navigation.screen.admin

sealed class AdminAsistenciaManualScreen(val route: String) {
    object AsistenciaManual: AdminAsistenciaManualScreen("admin/asistencia/manual")
}