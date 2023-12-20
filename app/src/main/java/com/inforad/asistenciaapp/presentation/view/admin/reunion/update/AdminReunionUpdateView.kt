package com.inforad.asistenciaapp.presentation.view.admin.reunion.update

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.presentation.components.DefaultTopBar
import com.inforad.asistenciaapp.presentation.view.admin.reunion.create.components.AdminReunionCreateContent
import com.inforad.asistenciaapp.presentation.view.admin.reunion.create.components.CreateReunion
import com.inforad.asistenciaapp.presentation.view.admin.reunion.update.components.AdminReunionUpdateContent
import com.inforad.asistenciaapp.presentation.view.admin.reunion.update.components.UpdateReunion

@Composable
fun AdminReunionUpdateView(navController: NavHostController) {
    Scaffold (
        topBar = {
            DefaultTopBar(
                title = "Actualizar Reunión",
                upAvailable = true,
                navController = navController
            )
        }
            ) {paddingValues ->
        AdminReunionUpdateContent(paddingValues = paddingValues)
    }
    UpdateReunion(navController)
}