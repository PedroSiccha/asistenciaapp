package com.inforad.asistenciaapp.presentation.view.admin.reunion.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.presentation.navigation.Graph
import com.inforad.asistenciaapp.presentation.view.admin.reunion.list.components.AdminReunionListContent

@Composable
fun AdminReunionListView(navController: NavHostController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 60.dp),
                onClick = { navController.navigate(route = Graph.ADMIN_REUNION) }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        },
        backgroundColor = Color(0xFFF4F6F5)
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(5.dp)
        ) {
            Text(
                text = "Próximas Reuniones",
                fontSize = 28.sp,
                //fontFamily = FontFamily(Font(R.font.gilroy-semibold),
                color = Color(0xFF1C1F1E))

            GetReunion(navController, paddingValues = paddingValues)
        }

    }

}