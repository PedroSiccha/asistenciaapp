package com.inforad.asistenciaapp.presentation.view.admin.colaborador.list.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.inforad.asistenciaapp.domain.model.User

@Composable
fun AdminColaboradorContent(navController: NavHostController, user: List<User>, paddingValues: PaddingValues) {
    val activity = LocalContext.current as? Activity
    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .padding(bottom = 55.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.fondoprincipal),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToScale(0.5f, 0.5f, 0.5f, 1f) }
            )
        )
        Column(Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.padding(paddingValues = paddingValues),
                text = "ADMIN COLABORADOR"
            )
        }
    }
}