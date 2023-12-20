package com.inforad.asistenciaapp.presentation.view.admin.reporte.list.components

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.R
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminScreen
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.list.GetAsistencia
import com.inforad.asistenciaapp.presentation.view.admin.reporte.list.AdminReporteViewModel
import com.inforad.asistenciaapp.presentation.view.admin.reporte.list.GetListReunion

@Composable
fun AdminReporteListContent(navController: NavHostController, paddingValues: PaddingValues, vm: AdminReporteViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Card(
                    modifier = Modifier
                        .size(120.dp)
                        .padding(8.dp)
                        .background(
                            color = Color(0xFF66CA98),
                            shape = RoundedCornerShape(size = 8.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .background(color = Color(0xFF66CA98))
                            .fillMaxSize(), // Añadido fillMaxSize para centrar el contenido verticalmente
                        verticalArrangement = Arrangement.Center, // Centrar verticalmente el contenido
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val promAsistentes = rememberUpdatedState(vm.state.prom_asistentes)
                        Text(
                            text = "${promAsistentes.value}",
                            fontSize = 18.sp,
                            fontWeight = FontWeight(600),
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Promedio de Asistentes",
                            fontSize = 12.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .size(120.dp)
                        .padding(8.dp)
                        .background(
                            color = Color(0xFFFF6C52),
                            shape = RoundedCornerShape(size = 8.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .background(color = Color(0xFFFF6C52))
                            .fillMaxSize(), // Añadido fillMaxSize para centrar el contenido verticalmente
                        verticalArrangement = Arrangement.Center, // Centrar verticalmente el contenido
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val promNoAsistentes = rememberUpdatedState(vm.state.prom_noasistentes)
                        Text(
                            text = "${ promNoAsistentes.value }",
                            fontSize = 18.sp,
                            fontWeight = FontWeight(600),
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Promedio de No Asistentes",
                            fontSize = 12.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Lista reuniones",
                    fontSize = 18.sp,
                    color = Color(0xFF1C1F1E)
                )
            }
            GetListReunion(navController = navController, paddingValues = paddingValues)
        }
    }
}