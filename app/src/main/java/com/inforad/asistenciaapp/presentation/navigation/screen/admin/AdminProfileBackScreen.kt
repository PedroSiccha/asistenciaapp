package com.inforad.asistenciaapp.presentation.navigation.screen.admin

import com.inforad.asistenciaapp.domain.model.Reunion

sealed class AdminProfileBackScreen(val route: String) {
    object ProfileBack: AdminProfileBackScreen("profile/detalle/back")
}
