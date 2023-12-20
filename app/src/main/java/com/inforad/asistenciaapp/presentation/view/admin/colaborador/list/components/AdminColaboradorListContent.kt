package com.inforad.asistenciaapp.presentation.view.admin.colaborador.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.model.User

@Composable
fun AdminColaboradorListContent(navController: NavHostController, user: List<User>, paddingValues: PaddingValues) {

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(paddingValues)
    ) {
        items(
            items = user
        ) {user ->
            AdminColaboradorListItem(navController = navController, user = user)
        }
    }
}