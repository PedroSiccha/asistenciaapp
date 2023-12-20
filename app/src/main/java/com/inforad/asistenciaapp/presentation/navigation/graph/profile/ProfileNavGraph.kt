package com.inforad.asistenciaapp.presentation.navigation.graph.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.navigation.screen.profile.ProfileScreen
import com.inforad.asistenciaapp.presentation.view.profile.detalle.ProfileDetalleView
import com.inforad.asistenciaapp.presentation.view.profile.update.ProfileUpdateView

fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PROFILE + "/{user}",
        startDestination = ProfileScreen.ProfileUpdate.route
    ) {
        composable(
            route = ProfileScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {data ->
                ProfileUpdateView(navController, userParam = data)
            }
        }

        composable(
            route = ProfileScreen.ProfileDetalle.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {data ->
                ProfileDetalleView(navController, userParam = data)
            }
        }
    }
}