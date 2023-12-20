package com.inforad.asistenciaapp.presentation.view.profile.detalle.components

import android.Manifest
import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.inforad.asistenciaapp.R
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.LaunchedEffect
import com.inforad.asistenciaapp.presentation.components.ButtonCustom
import com.inforad.asistenciaapp.presentation.navigation.Graph
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.view.View
import android.os.Environment
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.viewModelScope
import coil.compose.AsyncImage
import com.inforad.asistenciaapp.presentation.view.profile.detalle.ProfileDetalleViewModel
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers


@Composable
fun ProfileDetalleContent(paddingValues: PaddingValues, navController: NavHostController, vm: ProfileDetalleViewModel = hiltViewModel()) {
    val activity = LocalContext.current as? Activity
    val state = vm.state
    val stateDialog = remember {
        mutableStateOf(false)
    }


    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted: Boolean ->
            if (!isGranted) {
                Toast.makeText(context, "Permiso de camara denegado denegado", Toast.LENGTH_SHORT).show()
            }
        }
    )

    LaunchedEffect(Unit) {
        launcher.launch(Manifest.permission.CAMERA)
    }
    var showButtons by remember { mutableStateOf(true) }
    Box(
        modifier = Modifier
            .padding(paddingValues = paddingValues)

    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.fondopdf),
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )
        Column(Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(40.dp))

            if (!state.imagen.isNullOrBlank()) {
                Box(
                    modifier = Modifier
                        .size(215.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF96CE4C))
                        .align(Alignment.CenterHorizontally)
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(200.dp)
                            .align(Alignment.Center)
                            .clip(RoundedCornerShape(100.dp)),
                        model = state.imagen,
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                }



            } else {
                Box(
                    modifier = Modifier
                        .size(215.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF96CE4C))
                        .align(Alignment.CenterHorizontally)
                ) {
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .align(Alignment.Center)
                            .clip(RoundedCornerShape(100.dp)),
                        painter = painterResource(id = R.drawable.avataradmin),
                        contentDescription = ""
                    )
                }

            }

            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = state.dni!!,
                fontSize = 8.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = state.name,
                fontSize = 24.sp,
                fontFamily = FontFamily(
                    Font(R.font.gratis)
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 24.dp),
                text = "Padrón      : ${state.numeroPadron}",
                fontSize = 18.sp,
                fontFamily = FontFamily(
                    Font(R.font.salmapro_mediumnarrow)
                )
            )
            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 24.dp),
                text = "Dirección  : ${state.manzana}",
                fontSize = 18.sp,
                fontFamily = FontFamily(
                    Font(R.font.salmapro_mediumnarrow)
                )
            )
            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 24.dp),
                text = "Correo      : ${state.email}",
                fontSize = 18.sp,
                fontFamily = FontFamily(
                    Font(R.font.salmapro_mediumnarrow)
                )
            )
            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 24.dp),
                text = "Celular     : ${state.phone}",
                fontSize = 18.sp,
                fontFamily = FontFamily(
                    Font(R.font.salmapro_mediumnarrow)
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .clickable { stateDialog.value = true },
                painter = painterResource(id = R.drawable.logoprincipal),
                contentDescription = ""
            )

            val requestPermissionLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestPermission()
            ) { isGranted ->
                if (isGranted) {

                } else {
                    Toast.makeText(
                        context,
                        "Permiso de escritura en almacenamiento externo denegado",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(if (showButtons) 1f else 0f),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                backgroundColor = Color.White.copy(alpha = 0.7f)
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    if (showButtons) {
                    ButtonCustom(
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp)
                            .background(
                                color = Color(0xFFFFF7DC),
                                shape = RoundedCornerShape(size = 12.dp)
                            ),
                        color = Color(0xFFFFF7DC),
                        img = painterResource(id = R.drawable.lapiz),
                        onClick = {
                            navController.navigate(route = "${Graph.PROFILE}/${vm.user?.toJson()}")
                        }
                    )

                    ButtonCustom(
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp)
                            .background(
                                color = Color(0xFF66CA98),
                                shape = RoundedCornerShape(size = 12.dp)
                            ),
                        color = Color(0xFF66CA98),
                        img = painterResource(id = R.drawable.descargar_pdf),
                        onClick = {
                            showButtons = !showButtons
                            if (ContextCompat.checkSelfPermission(
                                    context,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                                ) !=
                                PackageManager.PERMISSION_GRANTED
                            ) {
                                ActivityCompat.requestPermissions(
                                    activity!!,
                                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                                    0
                                )
                            } else {
                                vm.viewModelScope.launch(Dispatchers.Main) {
                                    delay(1000)
                                    captureScreenshot(context, state.dni)
                                    vm.viewModelScope.launch(Dispatchers.Main) {
                                        delay(1000)
                                        showButtons = !showButtons
                                    }
                                }
                            }
                        }
                    )

                    ButtonCustom(
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(size = 12.dp)
                            ),
                        color = Color.White,
                        img = painterResource(id = R.drawable.girar_tarjeta),
                        onClick = {
                            navController.navigate(route = "${Graph.PROFILEBACK}/${vm.user?.toJson()}")
                        }
                    )

                    ButtonCustom(
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp)
                            .background(
                                color = Color(0xFFFFE2DC),
                                shape = RoundedCornerShape(size = 12.dp)
                            ),
                        color = Color(0xFFFFE2DC),
                        img = painterResource(id = R.drawable.borrador),
                        onClick = {
                            vm.deleteUser(vm.user.id ?: "")
                        }
                    )

                }
            }

        }

        }
    }
}

private fun captureScreenshot(context: Context, dni: String) {
    try {

        val rootView = (context as Activity).window.decorView.findViewById<View>(android.R.id.content)
        rootView.isDrawingCacheEnabled = true
        rootView.buildDrawingCache(true)
        val bitmap = Bitmap.createBitmap(rootView.drawingCache)
        rootView.isDrawingCacheEnabled = false
        val imageFileName = "${dni}_front.jpg"



        val carpeta = "/archivoSrMayo/${dni}"
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath + carpeta

        val dir = File(path)
        if (!dir.exists()) {
            dir.mkdirs()
        }

        val storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val imageFile = File(path, imageFileName)

        try {
            val outputStream: OutputStream = FileOutputStream(imageFile)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            outputStream.flush()
            outputStream.close()
            Toast.makeText(context, "Captura de pantalla guardada: ${imageFile.absolutePath}", Toast.LENGTH_LONG).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(context, "Error al guardar la captura de pantalla ${e.printStackTrace()}", Toast.LENGTH_LONG).show()
        } catch (ex: Exception) {
            Toast.makeText(context, "2 ${ex.message}", Toast.LENGTH_LONG).show()
        }

    } catch (ex: Exception) {
        Toast.makeText(context, "2 ${ex.message}", Toast.LENGTH_LONG).show()
    }


}

