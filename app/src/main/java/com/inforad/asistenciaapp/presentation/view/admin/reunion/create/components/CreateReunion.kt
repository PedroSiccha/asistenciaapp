package com.inforad.asistenciaapp.presentation.view.admin.reunion.create.components

import android.util.Log
import android.widget.Toast
import androidx.compose.material.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.presentation.components.ProgressBar
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminScreen
import com.inforad.asistenciaapp.presentation.view.admin.reunion.create.AdminReunionCreateViewModel

@Composable
fun CreateReunion(navController: NavHostController,vm: AdminReunionCreateViewModel = hiltViewModel()) {
    when(val response = vm.createReunionesResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                vm.msmSuccess()
                navController.navigate(route = AdminScreen.MenuAdmin.route)
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}