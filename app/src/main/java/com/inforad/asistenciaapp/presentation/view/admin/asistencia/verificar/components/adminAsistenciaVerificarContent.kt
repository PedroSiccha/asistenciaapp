package com.inforad.asistenciaapp.presentation.view.admin.asistencia.verificar.components

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
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
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.R
import com.inforad.asistenciaapp.presentation.components.DefaultButton
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminScreen

@SuppressLint("UnsafeOptInUsageError", "SuspiciousIndentation")
@Composable
fun AdminAsistenciaVerificarContent(paddingValues: PaddingValues, navController: NavHostController) {
    val activity = LocalContext.current as? Activity

            Box(
                modifier = Modifier
                    .padding(paddingValues = paddingValues)
                    .padding(bottom = 55.dp)
            ) {
                Column(
                    modifier = Modifier
                        .background(color = Color(0xFFFFFFFF))
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp),
                        backgroundColor = Color(0xFF66CA98),
                        elevation = 5.dp
                    ) {
                        ConstraintLayout(
                            modifier = Modifier
                                .padding(10.dp, bottom = 20.dp)
                                .background(color = Color(0xFF66CA98))
                        ) {
                            val (imgProfile, txtMyProfile, txtUserName, txtBio, rowNumbers) = createRefs()

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.comprobado_blanco),
                                    contentDescription = "Avatar",
                                    modifier = Modifier
                                        .size(250.dp)
                                        .padding(top = 48.dp)
                                )
                                Text(
                                    text = "ASISTIÓ",
                                    modifier = Modifier
                                        .padding(top = 15.dp),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp,
                                    color = Color(0xFFFFFFFF)
                                )

                                Text(
                                    text = "La asistencia se registró correctamente",
                                    modifier = Modifier
                                        .padding(start = 5.dp, end = 5.dp)
                                        .alpha(0.7f)
                                        .padding(top = 15.dp, start = 20.dp, end = 20.dp),
                                    fontWeight = FontWeight.Medium,
                                    textAlign = TextAlign.Center,
                                    lineHeight = 23.sp,
                                    letterSpacing = 1.sp,
                                    color = Color(0xFFFFFFFF)
                                )
                            }
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Bottom // Alineación en la parte inferior
                    ) {

                        DefaultButton(
                            modifier = Modifier.fillMaxWidth().padding(24.dp),
                            text = "ACEPTAR",
                            onClick = {
                                navController.navigate(route = AdminScreen.MenuAdmin.route)
                            },
                            color = Color(0xFF66CA98)
                        )
                    }
                }
            }
        }