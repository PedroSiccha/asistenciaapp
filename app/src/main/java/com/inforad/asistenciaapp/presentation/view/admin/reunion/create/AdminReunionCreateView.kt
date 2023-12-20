package com.inforad.asistenciaapp.presentation.view.admin.reunion.create

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.presentation.components.DefaultTopBar
import com.inforad.asistenciaapp.presentation.view.admin.reunion.create.components.AdminReunionCreateContent
import com.inforad.asistenciaapp.presentation.view.admin.reunion.create.components.CreateReunion

@Composable
fun AdminReunionCreateView(navController: NavHostController) {
    Scaffold (
        topBar = {
            DefaultTopBar(
                title = "Nueva Reunión",
                upAvailable = true,
                navController = navController
            )
        }
            ) {paddingValues ->
        AdminReunionCreateContent(paddingValues = paddingValues)
    }
    CreateReunion(navController)
}