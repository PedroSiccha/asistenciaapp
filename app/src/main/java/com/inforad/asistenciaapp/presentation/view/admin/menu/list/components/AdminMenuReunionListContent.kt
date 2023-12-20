package com.inforad.asistenciaapp.presentation.view.admin.menu.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.presentation.view.admin.reunion.list.components.AdminReunionListItem

@Composable
fun AdminMenuReunionListContent(navController: NavHostController, reunion: List<Reunion>, paddingValues: PaddingValues) {
    LazyColumn(
        modifier = Modifier.padding(paddingValues)
    ) {
        items(
            items = reunion
        ) {reunion ->
            AdminReunionListItem(navController = navController, reunion = reunion)
        }
    }
}