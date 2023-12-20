package com.inforad.asistenciaapp.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminQRScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminReunionScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.profile.ProfileScreen
import com.inforad.asistenciaapp.presentation.view.admin.reunion.update.AdminReunionUpdateView
import com.inforad.asistenciaapp.presentation.view.profile.detalle.ProfileDetalleView
import com.inforad.asistenciaapp.presentation.view.profile.update.ProfileUpdateView

fun NavGraphBuilder.AdminQRNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ADMIN_QR+ "/{user}",
        startDestination = ProfileScreen.ProfileDetalle.route
    ) {
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