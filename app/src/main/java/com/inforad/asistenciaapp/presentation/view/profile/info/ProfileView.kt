package com.inforad.asistenciaapp.presentation.view.profile.info

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.presentation.view.profile.info.components.ProfileContent

@Composable
fun ProfileView(navController: NavHostController) {
    Scaffold() { paddingValues ->
        ProfileContent(paddingValues = paddingValues, navController)
    }
}