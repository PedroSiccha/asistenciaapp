package com.inforad.asistenciaapp.presentation.navigation.graph.coll

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.presentation.navigation.Graph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.inforad.asistenciaapp.presentation.navigation.graph.profile.ProfileNavGraph
import com.inforad.asistenciaapp.presentation.navigation.screen.coll.CollScreen
import com.inforad.asistenciaapp.presentation.view.colaborador.manu.MenuView
import com.inforad.asistenciaapp.presentation.view.colaborador.reporte.list.CollReporteListView
import com.inforad.asistenciaapp.presentation.view.colaborador.reunion.list.CollReunionListView
import com.inforad.asistenciaapp.presentation.view.profile.info.ProfileView

@Composable
fun CollNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.COLL,
        startDestination = CollScreen.MenuColl.route
    ) {
        composable(route = CollScreen.MenuColl.route) {
            MenuView(navController)
        }

        composable(route = CollScreen.ReunionesList.route) {
            CollReunionListView(navController)
        }

        composable(route = CollScreen.ReportesList.route) {
            CollReporteListView(navController)
        }

        composable(route = CollScreen.Profile.route) {
            ProfileView(navController)
        }

        ProfileNavGraph(navController)
        CollReunionNavGraph(navController)
        CollReporteNavGraph(navController)
    }
}