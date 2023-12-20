package com.inforad.asistenciaapp.presentation.view.admin.asistencia.asismanual.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.R
import com.inforad.asistenciaapp.presentation.components.DefaultTextField
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminScreen
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.asismanual.AsistenciaManualViewModel
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.components.PreviewViewComposable

@Composable
fun AdminAsistenciaManualContent(paddingValues: PaddingValues, navController: NavHostController, vm: AsistenciaManualViewModel = hiltViewModel()) {
    val activity = LocalContext.current as? Activity
    val state = vm.state
    Box(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .padding(bottom = 55.dp)
    ) {
        Column(
            modifier = Modifier
                .background(color = Color.Gray)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp),
                backgroundColor = Color.White,
                elevation = 5.dp
            ) {
                ConstraintLayout(
                    modifier = Modifier
                        .padding(10.dp, bottom = 20.dp)
                        .background(color = Color.White)
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        color = MaterialTheme.colors.background
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "${ vm.reunion.asunto }",
                                modifier = Modifier
                                    .padding(top = 15.dp),
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color.DarkGray
                            )
                            Text(
                                text = "${ vm.reunion.detalle }",
                                modifier = Modifier
                                    .padding(start = 5.dp, end = 5.dp)
                                    .alpha(0.7f)
                                    .padding(top = 15.dp, start = 20.dp, end = 20.dp),
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.Center,
                                lineHeight = 23.sp,
                                letterSpacing = 1.sp,
                                color = Color.DarkGray
                            )
                            DefaultTextField(
                                modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 16.dp),
                                value = state.dni,
                                onValueChange = { vm.onDniInput(it) },
                                label = "DNI",
                                icon = Icons.Default.Person
                            )
                        }
                    }
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable {
                               vm.createAsistencia()
                    },
                RoundedCornerShape(10.dp),
                backgroundColor = Color(0xFF66CA98),
                elevation = 5.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(IntrinsicSize.Min),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Registrar",
                        fontSize = 18.sp,
                        //fontFamily = FontFamily(Font(R.font.gilroy-semibold),
                        color = Color(0xFFFFFFFF)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.flecha_derecho_blanco),
                        modifier = Modifier
                            .size(20.dp),
                        contentDescription = "Código QR"
                    )
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable {
                        navController.navigate(route = AdminScreen.MenuAdmin.route)
                    },
                RoundedCornerShape(10.dp),
                backgroundColor = Color(0xFFFF6C52),
                elevation = 5.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(IntrinsicSize.Min),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Cancelar",
                        fontSize = 18.sp,
                        //fontFamily = FontFamily(Font(R.font.gilroy-semibold),
                        color = Color(0xFFFFFFFF)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.cerrar_blanco),
                        modifier = Modifier
                            .size(20.dp),
                        contentDescription = "Código QR"
                    )
                }
            }
        }
    }
}