package com.inforad.asistenciaapp.presentation.view.admin.colaborador.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inforad.asistenciaapp.R
import com.inforad.asistenciaapp.domain.model.Reunion
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminAsistenciaScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminQRScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminReunionScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.profile.ProfileScreen
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.components.generateQRCode

@Composable
fun AdminColaboradorListItem(navController: NavHostController, user: User) {

    Box() {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(size = 28.dp)
                )
                .clickable {
                    navController.navigate(route = "${Graph.ADMIN_QR}/${user?.toJson()}")
                }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.background(color = Color(0xFFFFFFFF))) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        if (!user.imagen.isNullOrBlank()) {
                            AsyncImage(
                                modifier = Modifier
                                    .size(70.dp)
                                    .clip(CircleShape),
                                model = user.imagen,
                                contentDescription = ""
                            )
                        } else {
                            val qrCodeBitmap = generateQRCode("${ user.dni }", 200)
                            if (qrCodeBitmap != null) {
                                val imageBitmap = qrCodeBitmap.asImageBitmap()
                                Image(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(20.dp)),
                                    bitmap = imageBitmap,
                                    contentDescription = "QR Code"
                                )
                            } else {
                                // Manejar el caso en el que no se pueda generar el código QR
                                Image(
                                    painter = painterResource(id = R.drawable.avataradmin),
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(20.dp))
                                        .height(200.dp)
                                        .width(200.dp),
                                    contentDescription = "Código QR", contentScale = ContentScale.Crop
                                )
                            }
                        }

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                        ) {
                            Text(
                                text = "${ user.name } ${ user.lastname }",
                                fontSize = 18.sp,
                                //fontFamily = FontFamily(Font(R.font.gilroy-semibold),
                                color = Color(0xFF1C1F1E)
                            )
                            Text(
                                text = "Número de padrón: ${ user.numeroPadron }",
                                fontSize = 12.sp,
                                //fontFamily = FontFamily(Font(R.font.inter),
                                fontWeight = FontWeight(500),
                                color = Color(0xFFA7A6A5)
                            )

                            Text(
                                text = "Dirección: ${ user.manzana }",
                                fontSize = 12.sp,
                                //fontFamily = FontFamily(Font(R.font.inter),
                                fontWeight = FontWeight(500),
                                color = Color(0xFFA7A6A5)
                            )
                        }

                        Image(
                            painter = painterResource(id = R.drawable.permisos),
                            modifier = Modifier
                                .size(70.dp)
                                .padding(16.dp)
                                .clickable {
                                    navController.navigate(route = "${Graph.ADMIN_QR}/${user?.toJson()}")
                                },
                            contentDescription = "Código QR", contentScale = ContentScale.Crop
                        )

                    }
                }
            }
        }
    }
}