package com.inforad.asistenciaapp.presentation.view.admin.home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.inforad.asistenciaapp.presentation.navigation.graph.admin.AdminNavGraph
import com.inforad.asistenciaapp.presentation.view.admin.home.components.AdminBottomBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AdminHomeView(navController: NavHostController = rememberNavController()) {
    Scaffold (
        /*
            bottomBar = { AdminBottomBar(navController = navController) }
         */
            )

    {
        AdminNavGraph(navController = navController)
    }
}