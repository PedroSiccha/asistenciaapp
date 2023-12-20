package com.inforad.asistenciaapp.presentation.navigation.screen.coll

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class CollScreen(val route: String, val title: String, val icon: ImageVector) {
    object MenuColl: CollScreen(
        route = "coll/menu",
        title = "Inicio",
        icon = Icons.Default.Home
    )
    object ReunionesList: CollScreen(
        route = "coll/reunion/list",
        title = "Reuniones",
        icon = Icons.Default.List
    )
    object ReportesList: CollScreen(
        route = "coll/reporte/list",
        title = "Reportes",
        icon = Icons.Default.AccountBox
    )
    object Profile: CollScreen(
        route = "coll/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )
}
