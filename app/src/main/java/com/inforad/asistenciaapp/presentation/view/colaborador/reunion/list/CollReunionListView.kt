package com.inforad.asistenciaapp.presentation.view.colaborador.reunion.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.presentation.components.DefaultTopBar
import com.inforad.asistenciaapp.presentation.view.admin.reunion.list.GetReunion
import com.inforad.asistenciaapp.presentation.view.colaborador.reunion.list.components.CollReunionListContent
import com.inforad.asistenciaapp.presentation.view.profile.info.components.ProfileContent

@Composable
fun CollReunionListView(navController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Próximas Reuniones",
                upAvailable = true,
                navController = navController
            )
        }
    ) { paddingValues ->
        //CollReunionListContent(paddingValues = paddingValues)
        GetCollReunion(navController, paddingValues = paddingValues)
    }
}