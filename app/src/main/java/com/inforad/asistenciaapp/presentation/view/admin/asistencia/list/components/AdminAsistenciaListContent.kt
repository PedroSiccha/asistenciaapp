package com.inforad.asistenciaapp.presentation.view.admin.asistencia.list.components

import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.list.AsistenciaListViewModel
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.list.GetAsistencia

@Composable
fun AdminAsistenciaListContent(paddingValues: PaddingValues, navController: NavHostController, vm: AsistenciaListViewModel = hiltViewModel()) {
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
                        Text(
                            text = "0",
                            fontSize = 18.sp,
                            fontWeight = FontWeight(600),
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Asistentes",
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
                        Text(
                            text = "0",
                            fontSize = 18.sp,
                            fontWeight = FontWeight(600),
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "No Asistentes",
                            fontSize = 12.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            GetAsistencia(navController = navController, paddingValues = paddingValues)

        }

        FloatingActionButton(
            onClick = {
                      vm.cerrarReunion()
                      },
            modifier = Modifier.padding(bottom = 16.dp),
            backgroundColor = Color(0xFFFF6C52)
        ) {
            Row(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Finalizar Asistencia", color = Color.White)
            }
        }

    }
}