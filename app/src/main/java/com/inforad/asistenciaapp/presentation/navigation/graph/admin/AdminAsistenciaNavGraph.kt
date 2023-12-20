package com.inforad.asistenciaapp.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminAsistenciaScreen
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.asismanual.AdminAsistenciaManualView
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.AdminAsistenciaEscanearView
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.noverificar.AdminAsistenciaNoVerificarView
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.verificar.AdminAsistenciaVerificarView

fun NavGraphBuilder.AdminAsistenciaNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ADMIN_ASISTENCIA + "/{reunion}",
        startDestination = AdminAsistenciaScreen.AsistenciaEscaner.route
    ) {
        composable(route = AdminAsistenciaScreen.AsistenciaEscaner.route,
            arguments = listOf(navArgument("reunion") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("reunion")?.let { data ->
                AdminAsistenciaEscanearView(navController, reunionParam = data)
            }
        }

        composable(route = AdminAsistenciaScreen.AsistenciaManual.route,
            arguments = listOf(navArgument("reunion") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("reunion")?.let { data ->
                AdminAsistenciaManualView(navController, reunionParam = data)
            }
        }

        composable(
            route = AdminAsistenciaScreen.AsistenciaVerificar.route
        ) {
                AdminAsistenciaVerificarView(navController)
        }

        composable(
            route = AdminAsistenciaScreen.AsistenciaNoVerificar.route
        ) {
            AdminAsistenciaNoVerificarView(navController)
        }

    }
}