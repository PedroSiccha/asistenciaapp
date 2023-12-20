package com.inforad.asistenciaapp.presentation.navigation.graph.coll

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminReunionScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.coll.CollReunionScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.roles.RolesScreen
import com.inforad.asistenciaapp.presentation.view.admin.home.AdminHomeView
import com.inforad.asistenciaapp.presentation.view.admin.reunion.create.AdminReunionCreateView
import com.inforad.asistenciaapp.presentation.view.admin.reunion.update.AdminReunionUpdateView
import com.inforad.asistenciaapp.presentation.view.colaborador.home.CollHomeView
import com.inforad.asistenciaapp.presentation.view.colaborador.reunion.list.CollReunionListView
import com.inforad.asistenciaapp.presentation.view.roles.RolesView

fun NavGraphBuilder.CollReunionNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.COLL_REUNION,
        startDestination = CollReunionScreen.collReunionView.route
    ) {
        composable(route = CollReunionScreen.collReunionView.route) {
            CollReunionListView(navController)
        }

    }
}