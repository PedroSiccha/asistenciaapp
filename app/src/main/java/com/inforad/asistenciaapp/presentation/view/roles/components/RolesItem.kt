package com.inforad.asistenciaapp.presentation.view.roles.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.inforad.asistenciaapp.domain.model.Rol
import com.inforad.asistenciaapp.presentation.navigation.Graph

@Composable
fun RolesItem(rol: Rol, navController: NavHostController) {
    Spacer(modifier = Modifier.height(20.dp))
    Card(
        modifier = Modifier
            .wrapContentWidth(),
        shape = RoundedCornerShape(40.dp),
        backgroundColor = Color.White.copy(alpha = 0.3f),
    ) {
        Column(
            modifier = Modifier
                .clickable {
                navController.navigate(
                    route = rol.route
                ) {
                    popUpTo(
                        route = Graph.ROLES
                    ) {
                        inclusive = true
                    }
                }
            },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            AsyncImage(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
                    .padding(5.dp),
                model = rol.image,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = rol.name.uppercase(),
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}