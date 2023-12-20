package com.inforad.asistenciaapp.presentation.view.admin.asistencia.asismanual.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.presentation.components.ProgressBar
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminAsistenciaScreen
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.asismanual.AsistenciaManualViewModel
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.AsistenciaCreateViewModel

@Composable
fun AsistenciaManualComponent(navController: NavHostController, vm: AsistenciaManualViewModel = hiltViewModel()) {
    when (val response = vm.createAsistenciaResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
                LaunchedEffect(Unit) {
                    navController.navigate(
                        route = AdminAsistenciaScreen.AsistenciaVerificar.route
                    )
                }
        }
        is Resource.Failure -> {
            LaunchedEffect(Unit) {
                navController.navigate(
                    route = AdminAsistenciaScreen.AsistenciaNoVerificar.route
                )
            }
        }
        else -> {
            if (response != null) {
                Toast.makeText(
                    LocalContext.current,
                    "Hubo un error desconocido Cod. L01",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
