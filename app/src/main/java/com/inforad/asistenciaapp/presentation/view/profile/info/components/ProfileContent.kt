package com.inforad.asistenciaapp.presentation.view.profile.info.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.R
import com.inforad.asistenciaapp.presentation.MainActivity
import com.inforad.asistenciaapp.presentation.components.DefaultButton
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.components.generateQRCode
import com.inforad.asistenciaapp.presentation.view.profile.info.ProfileViewModel

@Composable
fun ProfileContent(paddingValues: PaddingValues, navController: NavHostController, vm: ProfileViewModel = hiltViewModel()) {
    val activity = LocalContext.current as? Activity
    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .padding(bottom = 55.dp)) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.fondoprincipal),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToScale(0.5f, 0.5f, 0.5f, 1f) }
            )
        )
        
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
                    val (imgProfile, txtMyProfile, txtUserName, txtBio, rowNumbers) = createRefs()
                    Text(
                        text = "Mi Perfil",
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .constrainAs(txtMyProfile) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                            }
                            .padding(start = 15.dp, bottom = 20.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.DarkGray
                    )
/*
                    val qrCodeBitmap = generateQRCode("${ vm.user?.dni }", 500)
                    if (qrCodeBitmap != null) {
                        val imageBitmap = qrCodeBitmap.asImageBitmap()
                        Image(bitmap = imageBitmap, contentDescription = "QR Code")
                    } else {
                        // Manejar el caso en el que no se pueda generar el código QR
                        Image(
                            painter = painterResource(id = R.drawable.avataradmin),
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .height(120.dp)
                                .width(120.dp)
                                .constrainAs(imgProfile) {
                                    top.linkTo(txtMyProfile.bottom)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                },
                            contentDescription = "Código QR", contentScale = ContentScale.Crop
                        )
                    }
 */

                    Image(
                        painter = painterResource(id = R.drawable.avataradmin),
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .height(120.dp)
                            .width(120.dp)
                            .constrainAs(imgProfile) {
                                top.linkTo(txtMyProfile.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            },
                        contentDescription = "Código QR", contentScale = ContentScale.Crop
                    )

                    Text(
                        text = "${vm.user?.name}",
                        modifier = Modifier
                            .constrainAs(txtUserName) {
                                top.linkTo(imgProfile.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .padding(top = 15.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.DarkGray
                    )

                    Text(
                        text = "${vm.user?.lastname} \n Número de Padrón ${vm.user?.numeroPadron}",
                        modifier = Modifier
                            .padding(start = 5.dp, end = 5.dp)
                            .constrainAs(txtBio) {
                                top.linkTo(txtUserName.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .alpha(0.7f)
                            .padding(top = 15.dp, start = 20.dp, end = 20.dp),
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        lineHeight = 23.sp,
                        letterSpacing = 1.sp,
                        color = Color.DarkGray
                    )

                    Row(
                        modifier = Modifier
                            .padding(top = 40.dp)
                            .constrainAs(rowNumbers) {
                                top.linkTo(txtBio.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    ) {
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Dirección",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                modifier = Modifier.alpha(0.6f)
                            )
                            Text(
                                text = "${vm.user?.manzana}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = Color.DarkGray
                            )
                        }
//
//                        Column(
//                            modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center,
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//                            Text(
//                                text = "Lotes",
//                                fontWeight = FontWeight.SemiBold,
//                                fontSize = 16.sp,
//                                modifier = Modifier.alpha(0.6f)
//                            )
//                            Text(
//                                text = "${vm.user?.lotesDetalle}",
//                                fontWeight = FontWeight.Bold,
//                                fontSize = 15.sp,
//                                color = Color.DarkGray
//                            )
//                        }

                        Column(
                            modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Metraje",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = Color.DarkGray,
                                modifier = Modifier.alpha(0.6f)
                            )
                            Text(
                                text = "${vm.user?.metros}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = Color.DarkGray
                            )
                        }
                    }
                }
            }
            IconButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 15.dp, top = 15.dp),
                onClick = {
                    vm.logout()
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                }
            ) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "",
                    tint = Color.White
                )
            }
            Image(
                modifier = Modifier
                    .size(250.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally), painter = painterResource(id = R.drawable.avataradmin), contentDescription = ""
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ProfileContentPreview() {
//    AsistenciaAppTheme {
//        ProfileContent(PaddingValues())
//    }
//}