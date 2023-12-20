package com.inforad.asistenciaapp.presentation.navigation.screen.admin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AdminScreen(val route: String, val title: String, val icon: ImageVector) {
    object MenuAdmin: AdminScreen(
        route = "admin/menu",
        title = "Inicio",
        icon = Icons.Default.Home
    )
    object ReunionesList: AdminScreen(
        route = "admin/reunion/list",
        title = "Reuniones",
        icon = Icons.Default.List
    )
    object ReportesList: AdminScreen(
        route = "admin/reporte/list",
        title = "Reportes",
        icon = Icons.Default.AccountBox
    )
    object ColaboradoresList: AdminScreen(
        route = "admin/coll/list",
        title = "Colaboradores",
        icon = Icons.Default.AccountBox
    )
    object Profile: AdminScreen(
        route = "admin/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )
}
