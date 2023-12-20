package com.inforad.asistenciaapp.presentation.view.colaborador.reunion.list.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.R
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.presentation.view.admin.reunion.list.components.AdminReunionListItem

@Composable
fun CollReunionListContent(navController: NavHostController, reunion: List<Reunion>, paddingValues: PaddingValues) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(paddingValues)
    ) {
        items(
            items = reunion
        ) {reunion ->
            CollReunionListItem(navController = navController, reunion = reunion)
        }
    }
}