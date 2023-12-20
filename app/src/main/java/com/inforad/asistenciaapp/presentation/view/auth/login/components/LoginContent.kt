package com.inforad.asistenciaapp.presentation.view.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.R
import com.inforad.asistenciaapp.presentation.components.DefaultButton
import com.inforad.asistenciaapp.presentation.components.DefaultTextField
import com.inforad.asistenciaapp.presentation.navigation.screen.auth.AuthScreen
import com.inforad.asistenciaapp.presentation.view.auth.login.LoginViewModel

@Composable
fun LoginContent(navController: NavHostController, paddingValues: PaddingValues, vm: LoginViewModel = hiltViewModel()) {

    val state = vm.state
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessage) {
        if (vm.errorMessage != "") {
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_LONG).show()
            vm.errorMessage = ""
        }
    }

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.logoprincipal),
            contentDescription = "Imagen de fondo",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToScale(0.5f, 0.5f, 0.5f, 1f) })
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                backgroundColor = Color.White.copy(alpha = 0.7f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 30.dp, end = 30.dp, start = 30.dp)
                        .verticalScroll(
                            rememberScrollState()
                        )
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "INGRESAR",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.dni,
                        onValueChange = {
                                        vm.onDniInput(it)
                        },
                        label = "Usuario",
                        icon = Icons.Default.Person,
                        keyboardType = KeyboardType.Number
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.password,
                        onValueChange = {
                                        vm.onPasswordInput(it)
                        },
                        label = "Contraseña",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        text = "INICIAR SESIÓN",
                        onClick = { vm.login() }
                    )
                    /*
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 17.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "No tienes cuenta?")
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(modifier = Modifier.clickable { navController.navigate(route = AuthScreen.Register.route) }, text = "Registrate", color = Color.Blue)
                    }
                     */
                }
            }
        }
    }
}