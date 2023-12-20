package com.inforad.asistenciaapp.presentation.view.admin.reporte.list.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.presentation.components.ProgressBar
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.view.admin.reporte.list.AdminReporteState
import com.inforad.asistenciaapp.presentation.view.admin.reporte.list.AdminReporteViewModel
import com.inforad.asistenciaapp.presentation.view.auth.login.LoginViewModel

@Composable
fun AdminReporte(navController: NavHostController, vm: AdminReporteViewModel = hiltViewModel()) {
    when(val response = vm.promedioAsistenciaResource) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                vm.state = AdminReporteState(
                    prom_asistentes = response.data.prom_asistentes,
                    prom_noasistentes = response.data.prom_noasistentes
                )
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo un error desaconocido Cod. L01", Toast.LENGTH_LONG).show()
            }
        }
    }
    
}