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
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.asismanual.AdminAsistenciaManualView
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.AdminAsistenciaEscanearView
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.list.AdminAsistenciaListView
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.noverificar.AdminAsistenciaNoVerificarView
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.verificar.AdminAsistenciaVerificarView

fun NavGraphBuilder.AdminAsistenciaListaNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ADMIN_ASISTENCIA_LISTA + "/{reunion}",
        startDestination = AdminAsistenciaListaScreen.AsistenciaLista.route
    ) {
        composable(route = AdminAsistenciaListaScreen.AsistenciaLista.route,
            arguments = listOf(navArgument("reunion") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("reunion")?.let { data ->
                //AdminAsistenciaManualView(navController, reunionParam = data)
                AdminAsistenciaListView(navController = navController, reunionParam = data)
            }
        }
    }
}