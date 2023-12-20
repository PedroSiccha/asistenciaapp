package com.inforad.asistenciaapp.presentation.view.colaborador.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.inforad.asistenciaapp.presentation.navigation.graph.coll.CollNavGraph
import com.inforad.asistenciaapp.presentation.view.colaborador.home.components.CollBottomBar

@Composable
fun CollHomeView(navController: NavHostController = rememberNavController()) {
    Scaffold(
        /*
        bottomBar = {
            CollBottomBar(
                navController = navController
            )
        }

         */
    ) {
        CollNavGraph(navController = navController)
    }
}