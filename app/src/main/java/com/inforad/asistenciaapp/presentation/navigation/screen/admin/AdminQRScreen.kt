package com.inforad.asistenciaapp.presentation.navigation.screen.admin

import com.inforad.asistenciaapp.presentation.navigation.screen.profile.ProfileScreen

sealed class AdminQRScreen(val route: String) {
    object AdminQR: AdminQRScreen("profile/detalle")
    object AdminQRVer: AdminQRScreen("admin/qr/ver/{user}") {
        fun passUser(user: String) = "admin/qr/ver/$user"
    }
}
