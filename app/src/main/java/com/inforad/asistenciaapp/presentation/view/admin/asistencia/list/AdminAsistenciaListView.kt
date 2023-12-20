package com.inforad.asistenciaapp.presentation.view.admin.asistencia.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.inforad.asistenciaapp.presentation.components.DefaultTopBar
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminMiembrosScreen
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.list.components.AdminAsistenciaListContent
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.list.components.GetCerrarAsistencia

@Composable
fun AdminAsistenciaListView(navController: NavHostController, reunionParam: String){
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Lista de Asistencia",
                navController = navController,
                upAvailable = true
            )

        }
    ) {paddingValues ->
        AdminAsistenciaListContent(paddingValues = paddingValues, navController = navController)
    }
    GetCerrarAsistencia(navController)

}