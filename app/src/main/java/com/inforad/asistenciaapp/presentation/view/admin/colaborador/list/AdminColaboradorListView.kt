package com.inforad.asistenciaapp.presentation.view.admin.colaborador.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.presentation.components.DefaultSearchView
import com.inforad.asistenciaapp.presentation.components.DefaultTopBar
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminMiembrosScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.auth.AuthScreen
import com.inforad.asistenciaapp.presentation.view.admin.colaborador.list.components.AdminColaboradorContent
import com.inforad.asistenciaapp.presentation.view.admin.colaborador.list.components.GetColaborador
import com.inforad.asistenciaapp.presentation.view.admin.reunion.list.GetReunion

@Composable
fun AdminColaboradorListView(navController: NavHostController, vm: AdminColaboradorListViewModel = hiltViewModel()) {
    vm.getUsers()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 60.dp),
                onClick = { navController.navigate(route = AdminMiembrosScreen.MiembroCreate.route) }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        },
        backgroundColor = Color(0xFFF4F6F5),
        topBar = {
            DefaultSearchView(
                value = vm.search,
                onValueChange = {text ->
                                vm.onSearchInput(text)
                    if (text.isNotBlank()) {
                        vm.getUsersByName(text)
                    }
                },
                navController = navController,
                onClick = {
                    if (vm.search.isNotBlank()){
                        vm.getUsersByName(vm.search)
                    }
                }
            )
        }
    ) { paddingValues ->
        GetColaborador(navController, paddingValues = paddingValues)
    }
}