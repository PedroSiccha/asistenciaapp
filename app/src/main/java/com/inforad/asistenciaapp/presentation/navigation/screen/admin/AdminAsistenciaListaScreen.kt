package com.inforad.asistenciaapp.presentation.navigation.screen.admin

sealed class AdminAsistenciaListaScreen(val route: String) {
    object AsistenciaLista: AdminAsistenciaListaScreen("admin/asistencia/lista")
}