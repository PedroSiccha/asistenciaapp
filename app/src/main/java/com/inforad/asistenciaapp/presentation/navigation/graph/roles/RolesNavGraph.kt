package com.inforad.asistenciaapp.presentation.navigation.graph.roles

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.navigation.screen.roles.RolesScreen
import com.inforad.asistenciaapp.presentation.view.admin.home.AdminHomeView
import com.inforad.asistenciaapp.presentation.view.colaborador.home.CollHomeView
import com.inforad.asistenciaapp.presentation.view.roles.RolesView

fun NavGraphBuilder.RolesNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ROLES,
        startDestination = RolesScreen.Roles.route
    ) {
        composable(route = RolesScreen.Roles.route) {
            RolesView(navController)
        }

        composable(route = Graph.COLL) {
            CollHomeView()
        }

        composable(route = Graph.ADMIN) {
            AdminHomeView()
        }
    }
}