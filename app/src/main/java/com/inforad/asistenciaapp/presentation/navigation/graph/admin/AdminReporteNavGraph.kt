package com.inforad.asistenciaapp.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminReporteScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminReunionScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.roles.RolesScreen
import com.inforad.asistenciaapp.presentation.view.admin.home.AdminHomeView
import com.inforad.asistenciaapp.presentation.view.admin.reporte.list.AdminReporteListView
import com.inforad.asistenciaapp.presentation.view.admin.reunion.create.AdminReunionCreateView
import com.inforad.asistenciaapp.presentation.view.admin.reunion.update.AdminReunionUpdateView
import com.inforad.asistenciaapp.presentation.view.colaborador.home.CollHomeView
import com.inforad.asistenciaapp.presentation.view.roles.RolesView

fun NavGraphBuilder.AdminReporteNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ADMIN_REPORTE,
        startDestination = AdminReporteScreen.ReporteView.route
    ) {
        composable(route = AdminReporteScreen.ReporteView.route) {
            AdminReporteListView(navController)
        }
    }
}