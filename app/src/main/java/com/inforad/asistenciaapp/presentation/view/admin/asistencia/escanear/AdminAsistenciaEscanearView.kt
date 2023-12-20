package com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.components.AdminAsistenciaEscanerContent
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.components.AsistenciaEscaner

@Composable
fun AdminAsistenciaEscanearView(navController: NavHostController = rememberNavController(), reunionParam: String) {
    Scaffold() { paddingValues ->
        AdminAsistenciaEscanerContent(paddingValues = paddingValues, navController = navController)
    }
    AsistenciaEscaner(navController = navController)
}