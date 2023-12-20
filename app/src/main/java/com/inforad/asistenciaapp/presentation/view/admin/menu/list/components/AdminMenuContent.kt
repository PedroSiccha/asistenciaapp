package com.inforad.asistenciaapp.presentation.view.admin.menu.list.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.R
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminAsistenciaScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminReunionScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminScreen
import com.inforad.asistenciaapp.presentation.view.admin.menu.list.AdminMenuViewModel


@Composable
fun AdminMenuContent(paddingValues: PaddingValues, navController: NavHostController, reunion: List<Reunion>) {
    val activity = LocalContext.current as? Activity
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .padding(bottom = 16.dp)
            .fillMaxHeight()
    ) {
        items (
            items = reunion
                )
        {reunion->
            Box() {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0x336295E2),
                            shape = RoundedCornerShape(size = 28.dp)
                        )
                ) {
                    Column(modifier = Modifier.background(color = Color(0x336295E2))) {
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
                                    text = "${ reunion.asunto }",
                                    fontSize = 18.sp,
                                    //fontFamily = FontFamily(Font(R.font.gilroy-semibold),
                                    color = Color(0xFF1C1F1E)
                                )
                                Text(
                                    text = "${ reunion.detalle }",
                                    fontSize = 12.sp,
                                    //fontFamily = FontFamily(Font(R.font.inter),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF1C1F1E)
                                )
                            }
                        }
                        Row() {
                            Row(
                                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.calendario_negro),
                                    contentDescription = "Favorite Icon",
                                    Modifier
                                        .size(24.dp)
                                        .padding(4.dp),
                                )
                                Text(
                                    text = "${ reunion.fecha }",
                                    fontSize = 14.sp,
                                    //fontFamily = FontFamily(Font(R.font.inter),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF1C1F1E)
                                )
                            }
                        }
                    }
                }
            }

        }
    }
}