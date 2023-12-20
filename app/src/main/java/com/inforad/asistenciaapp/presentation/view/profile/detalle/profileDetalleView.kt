package com.inforad.asistenciaapp.presentation.view.profile.detalle

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.presentation.components.DefaultTopBar
import com.inforad.asistenciaapp.presentation.view.profile.detalle.components.DeleteUser
import com.inforad.asistenciaapp.presentation.view.profile.detalle.components.ProfileDetalleContent

@Composable
fun ProfileDetalleView(navController: NavHostController, userParam: String) {
    Log.d("ProfileDetalleView", "Data: $userParam")
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Carnet Padrón",
                navController = navController,
                upAvailable = true
            )

        }
    ) { paddingValues ->
        ProfileDetalleContent(paddingValues = paddingValues, navController)
    }
    DeleteUser(navController = navController)
}