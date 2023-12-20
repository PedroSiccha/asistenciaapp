package com.inforad.asistenciaapp.presentation.navigation.graph.admin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.presentation.navigation.Graph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.inforad.asistenciaapp.presentation.navigation.graph.profile.ProfileNavGraph
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminScreen
import com.inforad.asistenciaapp.presentation.view.admin.colaborador.list.AdminColaboradorListView
import com.inforad.asistenciaapp.presentation.view.admin.menu.list.AdminMenuView
import com.inforad.asistenciaapp.presentation.view.admin.reporte.list.AdminReporteListView
import com.inforad.asistenciaapp.presentation.view.admin.reunion.list.AdminReunionListView
import com.inforad.asistenciaapp.presentation.view.profile.info.ProfileView

@Composable
fun AdminNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.MenuAdmin.route
    ) {
        composable(route = AdminScreen.MenuAdmin.route) {
            AdminMenuView(navController)
        }

        composable(route = AdminScreen.ReunionesList.route) {
            AdminReunionListView(navController)
        }

        composable(route = AdminScreen.ReportesList.route) {
            AdminReporteListView(navController)
        }

        composable(route = AdminScreen.ColaboradoresList.route) {
            AdminColaboradorListView(navController)
        }

        composable(route = AdminScreen.Profile.route) {
            ProfileView(navController)
        }

        ProfileNavGraph(navController)
        AdminReunionNavGraph(navController)
        AdminAsistenciaNavGraph(navController)
        AdminQRNavGraph(navController)
        AdminAsistenciaManualNavGraph(navController)
        AdminAsistenciaListaNavGraph(navController)
        AdminMiembroNavGraph(navController)
        AdminProfileBackNavGraph(navController)
        AdminReporteNavGraph(navController)
    }
}