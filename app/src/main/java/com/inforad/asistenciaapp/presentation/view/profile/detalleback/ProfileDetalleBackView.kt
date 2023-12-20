package com.inforad.asistenciaapp.presentation.view.profile.detalleback

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.presentation.components.DefaultTopBar
import com.inforad.asistenciaapp.presentation.view.profile.detalle.components.ProfileDetalleContent
import com.inforad.asistenciaapp.presentation.view.profile.detalleback.components.ProfileDetalleBackContent

@Composable
fun ProfileDetalleBackView(navController: NavHostController, userParam: String) {
    Log.d("ProfileDetalleBackView", "Data: $userParam")
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Carnet Padrón",
                navController = navController,
                upAvailable = true
            )

        }
    ) { paddingValues ->
        ProfileDetalleBackContent(paddingValues = paddingValues, navController)
    }
}