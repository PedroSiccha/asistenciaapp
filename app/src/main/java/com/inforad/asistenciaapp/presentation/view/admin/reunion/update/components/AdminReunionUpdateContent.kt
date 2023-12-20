package com.inforad.asistenciaapp.presentation.view.admin.reunion.update.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.inforad.asistenciaapp.R
import com.inforad.asistenciaapp.presentation.components.DefaultButton
import com.inforad.asistenciaapp.presentation.components.DefaultTextField
import com.inforad.asistenciaapp.presentation.view.admin.reunion.create.AdminReunionCreateViewModel
import com.inforad.asistenciaapp.presentation.view.admin.reunion.update.AdminReunionUpdateViewModel

@Composable
fun AdminReunionUpdateContent(paddingValues: PaddingValues, vm: AdminReunionUpdateViewModel = hiltViewModel()) {
    val state = vm.state
    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.fondoprincipal),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToScale(0.5f, 0.5f, 0.5f, 1f) }
            )
        )
        Column(Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                modifier = Modifier
                    .size(250.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .clickable { /*stateDialog.value = true*/ },
                painter = painterResource(id = R.drawable.avataradmin),
                contentDescription = ""
            )

            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp,
                ),
                backgroundColor = Color.White.copy(alpha = 0.7f)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.asunto,
                        onValueChange = { vm.onAsuntoInput(it) },
                        label = "Asunto",
                        icon = Icons.Default.Person
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.detalle,
                        onValueChange = { vm.onDetalleInput(it) },
                        label = "Detalle",
                        icon = Icons.Outlined.Person
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.fecha,
                        onValueChange = { vm.onFechaInput(it) },
                        label = "Fecha de Reuníon",
                        icon = Icons.Default.Phone
                    )

                    Spacer(modifier = Modifier.height(4.dp))
                    DefaultButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Actualizar Reunión",
                        onClick = { vm.updateReunion() }
                    )
                }
            }
        }
    }
}