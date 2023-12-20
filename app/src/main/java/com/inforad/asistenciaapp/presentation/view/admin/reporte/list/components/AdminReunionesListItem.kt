package com.inforad.asistenciaapp.presentation.view.admin.reporte.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.domain.model.Reunion

@Composable
fun AdminReunionesListItem(navController: NavHostController, reunionesResponse: Reunion) {
    Box() {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(size = 28.dp)
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = "${ reunionesResponse.asunto }",
                        fontSize = 10.sp,
                        color = Color(0xFF1C1F1E)
                    )
                    Text(
                        text = "${ reunionesResponse.detalle }",
                        fontSize = 8.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFA7A6A5)
                    )
                }
                Text(
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp),
                    text = "${ reunionesResponse.fecha }",
                    fontSize = 8.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFA7A6A5)
                )
            }
        }
    }
}