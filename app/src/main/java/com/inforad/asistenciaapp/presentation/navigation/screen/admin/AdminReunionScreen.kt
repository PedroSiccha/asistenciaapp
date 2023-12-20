package com.inforad.asistenciaapp.presentation.navigation.screen.admin

import com.inforad.asistenciaapp.domain.model.Reunion

sealed class AdminReunionScreen(val route: String) {
    object ReunionCreate: AdminReunionScreen("admin/reunion/create")
    object ReunionUpdate: AdminReunionScreen("admin/reunion/update/{reunion}") {
        fun passReunion(reunion: String) = "admin/reunion/update/$reunion"
    }
}
