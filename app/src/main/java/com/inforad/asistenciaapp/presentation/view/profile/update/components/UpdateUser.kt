package com.inforad.asistenciaapp.presentation.view.profile.update.components

import android.widget.Toast
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.presentation.components.ProgressBar
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminScreen
import com.inforad.asistenciaapp.presentation.view.profile.update.ProfileUpdateViewModel

@Composable
fun UpdateUser(navController: NavHostController, vm: ProfileUpdateViewModel = hiltViewModel()) {
    val scaffoldState = rememberScaffoldState()
    when(val response = vm.updateRespone) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(route = AdminScreen.MenuAdmin.route)
                scaffoldState.snackbarHostState.showSnackbar("Los datos se actualizacion correctamente")
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}