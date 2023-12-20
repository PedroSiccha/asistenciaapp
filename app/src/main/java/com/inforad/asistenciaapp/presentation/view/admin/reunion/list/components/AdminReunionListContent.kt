package com.inforad.asistenciaapp.presentation.view.admin.reunion.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.domain.model.Reunion

@Composable
fun AdminReunionListContent(navController: NavHostController, reunion: List<Reunion>, paddingValues: PaddingValues) {

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(paddingValues)
    ) {
        items(
            items = reunion
        ) {reunion ->
            AdminReunionListItem(navController = navController, reunion = reunion)
        }
    }
}