package com.inforad.asistenciaapp.presentation.navigation.graph.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.presentation.navigation.Graph
import androidx.navigation.compose.NavHost
import com.inforad.asistenciaapp.presentation.navigation.graph.auth.AuthNavGraph
import com.inforad.asistenciaapp.presentation.navigation.graph.roles.RolesNavGraph

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ) {
        AuthNavGraph(navController = navController)
        RolesNavGraph(navController = navController)

    }
}