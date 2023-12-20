package com.inforad.asistenciaapp.presentation.navigation.screen.profile

sealed class ProfileScreen(val route: String) {
    object ProfileUpdate: ProfileScreen("profile/update")
    object ProfileDetalle: ProfileScreen("profile/detalle")
}
