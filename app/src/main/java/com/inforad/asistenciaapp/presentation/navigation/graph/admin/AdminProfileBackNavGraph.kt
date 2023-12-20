package com.inforad.asistenciaapp.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminAsistenciaListaScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminAsistenciaManualScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminAsistenciaScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminProfileBackScreen
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.asismanual.AdminAsistenciaManualView
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.AdminAsistenciaEscanearView
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.noverificar.AdminAsistenciaNoVerificarView
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.verificar.AdminAsistenciaVerificarView
import com.inforad.asistenciaapp.presentation.view.profile.detalleback.ProfileDetalleBackView

fun NavGraphBuilder.AdminProfileBackNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PROFILEBACK + "/{user}",
        startDestination = AdminProfileBackScreen.ProfileBack.route
    ) {
        composable(route = AdminProfileBackScreen.ProfileBack.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let { data ->
                ProfileDetalleBackView(navController, userParam = data)
            }
        }
    }
}