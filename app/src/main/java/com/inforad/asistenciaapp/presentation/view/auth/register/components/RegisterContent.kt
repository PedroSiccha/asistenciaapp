package com.inforad.asistenciaapp.presentation.view.auth.register.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import coil.compose.AsyncImage
import com.inforad.asistenciaapp.R
import com.inforad.asistenciaapp.presentation.components.DefaultButton
import com.inforad.asistenciaapp.presentation.components.DefaultTextField
import com.inforad.asistenciaapp.presentation.components.DialogCapturePicture
import com.inforad.asistenciaapp.presentation.view.auth.register.RegisterViewModel

@Composable
fun RegisterContent(paddingValues: PaddingValues, vm: RegisterViewModel = hiltViewModel()) {
    val state = vm.state
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessage) {
        if (vm.errorMessage != "") {
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_LONG).show()
            vm.errorMessage = ""
        }
    }

    val stateDialog = remember {
        mutableStateOf(false)
    }
    vm.resultingActivityHandler.handle()

    DialogCapturePicture(
        state = stateDialog,
        takePhoto = { vm.takePhoto() },
        pickImage = { vm.pickImage() }
    )

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize()) {
        Image(modifier = Modifier.fillMaxSize(), painter = painterResource(id = R.drawable.login), contentDescription = "", contentScale = ContentScale.Crop,  colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToScale(0.5f, 0.5f, 0.5f, 1f) }))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!state.imagen.isNullOrBlank()) {
                AsyncImage(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .padding(top = 20.dp)
                        .clickable {
                            stateDialog.value = true
                        },
                    model = state.imagen,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(200.dp)
                        .padding(top = 20.dp)
                        .clickable {
                            stateDialog.value = true
                        },
                    painter = painterResource(id = R.drawable.agregarusuario),
                    contentDescription = ""
                )
            }

            Text(modifier = Modifier.padding(top = 7.dp), text = "Ingresar Datos", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.White)
            Spacer(modifier = Modifier.weight(1f))
            Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp), backgroundColor = Color.White.copy(alpha = 0.8f)) {
                Column(modifier = Modifier
                    .padding(top = 30.dp, start = 30.dp, end = 30.dp, bottom = 30.dp)
                    .verticalScroll(
                        rememberScrollState()
                    )) {
                    Text(modifier = Modifier.padding(vertical = 20.dp), text = "REGISTRO", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Black)
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.name,
                        onValueChange = { vm.onNameInput(it) },
                        label = "Nombres",
                        icon = Icons.Default.Person
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.lastname,
                        onValueChange = { vm.onLastnameInput(it) },
                        label = "Apellidos",
                        icon = Icons.Outlined.Person
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.dni,
                        onValueChange = { vm.onDniInput(it) },
                        label = "DNI",
                        icon = Icons.Default.AccountBox
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.email,
                        onValueChange = { vm.onEmailInput(it) },
                        label = "Correo Electrónico",
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.telefono,
                        onValueChange = { vm.onTelefonoInput(it) },
                        label = "Teléfono",
                        icon = Icons.Default.Phone,
                        keyboardType = KeyboardType.Number
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "${ state.numeroPadron }",
                        onValueChange = { vm.onNumeroPadronInput(it.toInt()) },
                        label = "Número de Padrón",
                        icon = Icons.Default.List,
                        keyboardType = KeyboardType.Number
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.manzana,
                        onValueChange = { vm.onManzanaInput(it) },
                        label = "Dirección",
                        icon = Icons.Default.List,
                        keyboardType = KeyboardType.Text
                    )

//                    DefaultTextField(
//                        modifier = Modifier.fillMaxWidth(),
//                        value = "${ state.lote }",
//                        onValueChange = { vm.onLoteInput(it.toInt()) },
//                        label = "Lote",
//                        icon = Icons.Default.List,
//                        keyboardType = KeyboardType.Number
//                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.metros,
                        onValueChange = { vm.onMetrosInput(it) },
                        label = "Metros",
                        icon = Icons.Default.List,
                        keyboardType = KeyboardType.Number
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.lotesDetalle,
                        onValueChange = { vm.onLotesDetallesInput(it) },
                        label = "Lotes",
                        icon = Icons.Default.List,
                        keyboardType = KeyboardType.Number
                    )

//                    DefaultTextField(
//                        modifier = Modifier.fillMaxWidth(),
//                        value = state.lotesCantidad,
//                        onValueChange = { vm.onLotesCantidadInput(it) },
//                        label = "Cantidad de Lotes",
//                        icon = Icons.Default.List,
//                        keyboardType = KeyboardType.Number
//                    )

                    Spacer(modifier = Modifier.height(15.dp))
                    DefaultButton(modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp), text = "CONFIRMAR", onClick = { vm.onRegister() })
                }
            }
        }
    }
}