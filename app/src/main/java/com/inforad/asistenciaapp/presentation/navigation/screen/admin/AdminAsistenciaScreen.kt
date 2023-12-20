package com.inforad.asistenciaapp.presentation.navigation.screen.admin

sealed class AdminAsistenciaScreen(val route: String) {
    object AsistenciaEscaner: AdminAsistenciaScreen("admin/asistencia/escaner")
    object AsistenciaManual: AdminAsistenciaScreen("admin/asistencia/manual")
    object AsistenciaVerificar: AdminAsistenciaScreen("admin/asistencia/verificar")
    object AsistenciaNoVerificar: AdminAsistenciaScreen("admin/asistencia/noverificar")
}
