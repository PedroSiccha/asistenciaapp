package com.inforad.asistenciaapp.presentation.view.admin.menu.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.R
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminAsistenciaScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminReporteScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminScreen
import com.inforad.asistenciaapp.presentation.view.admin.menu.list.components.AdminMenuContent
import com.inforad.asistenciaapp.presentation.view.admin.reunion.list.GetReunion

@Composable
fun AdminMenuView(navController: NavHostController, vm: AdminMenuViewModel = hiltViewModel()) {
    Scaffold() { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .offset(0.dp)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        top = 48.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .padding(
                            start = 5.dp,
                            top = 5.dp
                        )
                ) {
                    Text(
                        text = "Hola, ${ vm.user?.name }!",
                        fontSize = 20.sp,
                        //fontFamily = FontFamily(Font(R.font.gilroy-semibold),
                        color = Color(0xFF1C1F1E)
                    )
                    Text(
                        text = "Numero de Padron ${ vm.user?.numeroPadron }",
                        fontSize = 14.sp,
                        //fontFamily = FontFamily(Font(R.font.inter),
                        fontWeight = FontWeight(500),
                        color = Color(0xFFA7A6A5)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.avatarcoll),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(70.dp)
                        .padding(5.dp),
                )
            }
            if (vm.lastReunionResponse?.id != null) {
                Box() {
                    Card(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFF6295E2),
                                shape = RoundedCornerShape(size = 28.dp)
                            )
                            .clickable {
                                navController.navigate(
                                    route = "${ Graph.ADMIN_ASISTENCIA }/${ vm.lastReunionResponse?.toJson() }"
                                )
                            }
                    ) {
                        Column(modifier = Modifier.background(color = Color(0xFF6295E2))) {
                            Row() {
                                Image(
                                    painter = painterResource(id = R.drawable.calendario),
                                    contentDescription = "Avatar",
                                    modifier = Modifier
                                        .size(50.dp)
                                        .padding(5.dp)
                                        .align(Alignment.CenterVertically),
                                    contentScale = ContentScale.Crop
                                )
                                Column(
                                    modifier = Modifier.padding(5.dp)
                                ) {
                                    Text(
                                        text = "${ vm.lastReunionResponse?.asunto }",
                                        fontSize = 18.sp,
                                        //fontFamily = FontFamily(Font(R.font.gilroy-semibold),
                                        color = Color(0xFFFFFFFF)
                                    )
                                    Text(
                                        text = "${ vm.lastReunionResponse?.detalle }",
                                        fontSize = 12.sp,
                                        //fontFamily = FontFamily(Font(R.font.inter),
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFFE0EAF9)
                                    )
                                }
                            }
                            Row() {
                                Row(
                                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.calendario_blanco),
                                        contentDescription = "Favorite Icon",
                                        Modifier
                                            .size(24.dp)
                                            .padding(4.dp),
                                    )
                                    Text(
                                        text = "${ vm.lastReunionResponse?.fecha }",
                                        fontSize = 14.sp,
                                        //fontFamily = FontFamily(Font(R.font.inter),
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFFE0EAF9)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            Text(
                modifier = Modifier.padding(16.dp),
                text = "Opciones",
                fontSize = 18.sp,
                //fontFamily = FontFamily(Font(R.font.gilroy-semibold),
                color = Color(0xFF1C1F1E)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier.clickable {
                        navController.navigate(
                            route = AdminScreen.ColaboradoresList.route
                        )
                    },
                    contentAlignment = Alignment.Center
                ) {
                    Card(
                        modifier = Modifier
                            .padding(16.dp)
                            .size(90.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(size = 28.dp)
                            )
                    ) {
                        Column(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.padron),
                                contentDescription = "Avatar",
                                modifier = Modifier
                                    .size(43.dp)
                                    .padding(5.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                            Text(
                                text = "Padrón",
                                fontSize = 12.sp,
                                //fontFamily = FontFamily(Font(R.font.gilroy-semibold),
                                color = Color(0xFF1C1F1E),
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier.clickable {
                        navController.navigate(
                            route = AdminScreen.ReunionesList.route
                        )
                    },
                    contentAlignment = Alignment.Center
                ) {
                    Card(
                        modifier = Modifier
                            .padding(16.dp)
                            .size(90.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(size = 28.dp)
                            )
                    ) {
                        Column(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.discusion),
                                contentDescription = "Avatar",
                                modifier = Modifier
                                    .size(43.dp)
                                    .padding(5.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                            Text(
                                text = "Reuniones",
                                fontSize = 12.sp,
                                //fontFamily = FontFamily(Font(R.font.gilroy-semibold),
                                color = Color(0xFF1C1F1E),
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier.clickable {
                        navController.navigate(
                            route = AdminReporteScreen.ReporteView.route
                        )
                    },
                    contentAlignment = Alignment.Center
                ) {
                    Card(
                        modifier = Modifier
                            .padding(16.dp)
                            .size(90.dp)
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(size = 28.dp)
                            )
                    ) {
                        Column(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.reporte),
                                contentDescription = "Avatar",
                                modifier = Modifier
                                    .size(43.dp)
                                    .padding(5.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                            Text(
                                text = "Reportes",
                                fontSize = 12.sp,
                                //fontFamily = FontFamily(Font(R.font.gilroy-semibold),
                                color = Color(0xFF1C1F1E),
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
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
                    text = "Proximas reuniones",
                    fontSize = 18.sp,
                    //fontFamily = FontFamily(Font(R.font.gilroy-semibold),
                    color = Color(0xFF1C1F1E)
                )
                Text(
                    modifier = Modifier.clickable {
                        navController.navigate(
                            route = AdminScreen.ReunionesList.route
                        )
                    },
                    text = "Ver todas",
                    fontSize = 12.sp,
                    //fontFamily = FontFamily(Font(R.font.gilroy-semibold),
                    color = Color(0xFF1C1F1E)
                )
            }

            GetReunionMenu(navController, paddingValues = paddingValues)
        }

    }
}