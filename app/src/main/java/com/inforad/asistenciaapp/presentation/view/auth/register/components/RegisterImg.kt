package com.inforad.asistenciaapp.presentation.view.auth.register.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.presentation.components.ProgressBar
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminScreen
import com.inforad.asistenciaapp.presentation.view.auth.register.RegisterViewModel

@Composable
fun RegisterImg(navController: NavHostController, vm: RegisterViewModel = hiltViewModel()) {
    when(val response = vm.registerUserRespone) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                vm.msgSuccess()
                navController.navigate(
                    route = AdminScreen.ColaboradoresList.route
                )
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, "${ response.message }", Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Error desconocido Cod. R01", Toast.LENGTH_LONG).show()
            }
        }
    }
}