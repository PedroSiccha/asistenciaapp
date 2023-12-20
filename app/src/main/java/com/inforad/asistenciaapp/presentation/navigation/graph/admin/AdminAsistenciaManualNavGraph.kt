package com.inforad.asistenciaapp.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminAsistenciaManualScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminAsistenciaScreen
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.asismanual.AdminAsistenciaManualView
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.AdminAsistenciaEscanearView
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.noverificar.AdminAsistenciaNoVerificarView
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.verificar.AdminAsistenciaVerificarView

fun NavGraphBuilder.AdminAsistenciaManualNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ADMIN_ASISTENCIA_MANUAL + "/{reunion}",
        startDestination = AdminAsistenciaManualScreen.AsistenciaManual.route
    ) {
        composable(route = AdminAsistenciaManualScreen.AsistenciaManual.route,
            arguments = listOf(navArgument("reunion") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("reunion")?.let { data ->
                AdminAsistenciaManualView(navController, reunionParam = data)
            }
        }
    }
}