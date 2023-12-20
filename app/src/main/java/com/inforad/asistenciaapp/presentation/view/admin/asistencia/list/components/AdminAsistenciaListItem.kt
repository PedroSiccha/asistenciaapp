package com.inforad.asistenciaapp.presentation.view.admin.asistencia.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.inforad.asistenciaapp.R
import com.inforad.asistenciaapp.domain.response.AsistenciaResponse
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.components.generateQRCode

@Composable
fun AdminAsistenciaListItem(navController: NavHostController, asistenciaResponse: AsistenciaResponse) {
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
                if (!asistenciaResponse.user?.imagen.isNullOrBlank()) {
                    AsyncImage(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(100.dp))
                            .padding(5.dp),
                        model = asistenciaResponse.user?.imagen,
                        contentDescription = ""
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.avataradmin),
                        modifier = Modifier
                            .clip(RoundedCornerShape(100.dp))
                            .size(8.dp)
                            .padding(5.dp),
                        contentDescription = "Código QR", contentScale = ContentScale.Crop
                    )
                }
                Column(
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = "${ asistenciaResponse.user?.name } ${ asistenciaResponse.user?.lastname }",
                        fontSize = 10.sp,
                        color = Color(0xFF1C1F1E)
                    )
                    Text(
                        text = "${ asistenciaResponse.user?.numeroPadron }",
                        fontSize = 8.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFA7A6A5)
                    )
                }
                Text(
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp),
                    text = "${ asistenciaResponse.hora }",
                    fontSize = 8.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFA7A6A5)
                )
            }
        }
    }
}