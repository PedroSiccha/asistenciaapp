package com.inforad.asistenciaapp.presentation.view.admin.reunion.list.components

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
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminAsistenciaScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminReunionScreen

@Composable
fun AdminReunionListItem(navController: NavHostController, reunion: Reunion) {

    Box(

    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(size = 28.dp)
                )
                .clickable {
                    navController.navigate(
                        route = AdminAsistenciaScreen.AsistenciaEscaner.route
                    )
                }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.background(color = Color(0xFFFFFFFF))) {
                    Row() {
                        Column(
                            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                        ) {
                            Text(
                                text = reunion.asunto,
                                fontSize = 18.sp,
                                //fontFamily = FontFamily(Font(R.font.gilroy-semibold),
                                color = Color(0xFF1C1F1E)
                            )
                            Text(
                                text = reunion.detalle!!,
                                fontSize = 12.sp,
                                //fontFamily = FontFamily(Font(R.font.inter),
                                fontWeight = FontWeight(500),
                                color = Color(0xFFA7A6A5)
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                    ) {
                        Icon(
                            Icons.Default.AccountBox,
                            contentDescription = "Favorite Icon",
                            tint = Color(0xFF1C1F1E)
                        )
                        Text(
                            text = reunion.fecha,
                            fontSize = 14.sp,
                            //fontFamily = FontFamily(Font(R.font.inter),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF1C1F1E)
                        )
                    }
                }

                Row(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .padding(5.dp)
                            .background(
                                color = Color(0xFFFFF7DC),
                                shape = RoundedCornerShape(size = 28.dp)
                            )
                            .clickable {
                                navController.navigate(
                                    route = AdminReunionScreen.ReunionUpdate.passReunion(reunion.toJson())
                                )
                            },
                        backgroundColor = Color(0xFFFFF7DC)
                    ) {
                        Image(
                            modifier = Modifier
                                .size(25.dp),
                            painter = painterResource(id = R.drawable.lapiz),
                            contentDescription = ""
                        )
                    }
                    Spacer(modifier = Modifier.size(5.dp))
                    Card(
                        modifier = Modifier
                            .padding(5.dp)
                            .background(
                                color = Color(0xFFFFE2DC),
                                shape = RoundedCornerShape(size = 28.dp)
                            )
                            .clickable {

                            },
                        backgroundColor = Color(0xFFFFE2DC)
                    ) {
                        Image(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.borrador),
                            contentDescription = ""
                        )
                    }

                }
            }
        }
    }
    /*
    Column(
        Modifier
            .padding(start = 20.dp, end = 20.dp, top = 15.dp)
            .height(90.dp)
    ) {
        Row() {
            Image(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(10.dp)),
                painter = painterResource(id = R.drawable.fondoprincipal),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                Modifier.weight(1f)
            ) {
                Text(
                    text = reunion.asunto,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = reunion.detalle!!,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = reunion.fecha,
                    fontSize = 10.sp
                )
            }
            Spacer(modifier = Modifier.width(15.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.size(25.dp).clickable { navController.navigate(
                        route = AdminReunionScreen.ReunionUpdate.passReunion(reunion.toJson())
                    ) },
                    painter = painterResource(id = R.drawable.lapiz),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.size(5.dp))
                Image(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(id = R.drawable.borrador),
                    contentDescription = ""
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            color = Color.Gray,
            startIndent = 30.dp
        )
    }
    */

}