package com.inforad.asistenciaapp.presentation.view.admin.reporte.list

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.presentation.components.ProgressBar
import com.inforad.asistenciaapp.presentation.view.admin.reporte.list.components.ReunionesListContent

@Composable
fun GetListReunion(navController: NavHostController, paddingValues: PaddingValues, vm: AdminReporteViewModel = hiltViewModel()) {
    when(val response = vm.reunionResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            ReunionesListContent(navController = navController, reunionesResponse = response.data, paddingValues = paddingValues)
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Error Desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}