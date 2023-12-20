package com.inforad.asistenciaapp.presentation.view.admin.reunion.list

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.presentation.components.ProgressBar
import com.inforad.asistenciaapp.presentation.view.admin.colaborador.list.AdminColaboradorListViewModel
import com.inforad.asistenciaapp.presentation.view.admin.reporte.list.components.AdminReporteListContent
import com.inforad.asistenciaapp.presentation.view.admin.reunion.list.components.AdminReunionListContent

@Composable
fun GetReunion(navController: NavHostController, paddingValues: PaddingValues, vm: AdminReunionListViewModel = hiltViewModel()) {
    when(val response = vm.reunionesResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            AdminReunionListContent(navController, reunion = response.data, paddingValues)
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Error desconocio", Toast.LENGTH_LONG).show()
            }
        }
    }
}