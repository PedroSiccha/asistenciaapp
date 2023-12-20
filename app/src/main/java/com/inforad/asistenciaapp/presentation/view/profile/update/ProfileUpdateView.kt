package com.inforad.asistenciaapp.presentation.view.profile.update

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.presentation.components.DefaultTopBar
import com.inforad.asistenciaapp.presentation.view.profile.update.components.ProfileUpdateContent
import com.inforad.asistenciaapp.presentation.view.profile.update.components.UpdateUser

@Composable
fun ProfileUpdateView(navController: NavHostController, userParam: String) {
    Log.d("ProfileUpdateView", "Data: $userParam")
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar Perfil",
                navController = navController,
                upAvailable = true
            )

        }
    ) { paddingValues ->
        ProfileUpdateContent(paddingValues = paddingValues, navController)
    }
    UpdateUser(navController)
}