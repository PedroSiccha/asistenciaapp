package com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.components

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.zxing.BinaryBitmap
import com.google.zxing.MultiFormatReader
import com.google.zxing.PlanarYUVLuminanceSource
import com.google.zxing.RGBLuminanceSource
import com.google.zxing.ReaderException
import com.google.zxing.common.HybridBinarizer
import com.inforad.asistenciaapp.domain.util.Resource
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminAsistenciaScreen
import com.inforad.asistenciaapp.presentation.navigation.screen.admin.AdminScreen
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.AsistenciaCreateViewModel
import com.inforad.asistenciaapp.presentation.view.admin.reunion.create.AdminReunionCreateViewModel
import java.util.concurrent.Executors

@androidx.camera.core.ExperimentalGetImage
@Composable
fun PreviewViewComposable(navController: NavHostController, vm: AsistenciaCreateViewModel = hiltViewModel()) {
    var dataProcessed = false
    AndroidView(
        { context ->
            val cameraExecutor = Executors.newSingleThreadExecutor()
            val previewView = PreviewView(context).also {
                it.scaleType = PreviewView.ScaleType.FILL_CENTER
            }
            val cameraProviderFuture = ProcessCameraProvider.getInstance(context)
            cameraProviderFuture.addListener({
                val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()
                val preview = Preview.Builder()
                    .build()
                    .also {
                        it.setSurfaceProvider(previewView.surfaceProvider)
                    }
                val imageCapture = ImageCapture.Builder().build()
                val imageAnalyzer = ImageAnalysis.Builder()
                    .build()
                    .also {
                        it.setAnalyzer(cameraExecutor) { image ->
                            if (vm.scanEnabled && !dataProcessed) {
                                val rotationDegrees = image.imageInfo.rotationDegrees
                                val mainHandler = Handler(Looper.getMainLooper())
                                val yBuffer = image.planes[0].buffer
                                val uBuffer = image.planes[1].buffer
                                val vBuffer = image.planes[2].buffer
                                val ySize = yBuffer.remaining()
                                val uSize = uBuffer.remaining()
                                val vSize = vBuffer.remaining()
                                val data = ByteArray(ySize + uSize + vSize)
                                yBuffer.get(data, 0, ySize)
                                uBuffer.get(data, ySize, uSize)
                                vBuffer.get(data, ySize + uSize, vSize)
                                val source = PlanarYUVLuminanceSource(
                                    data, image.width, image.height,
                                    0, 0, image.width, image.height,
                                    false
                                )
                                val bitmap = BinaryBitmap(HybridBinarizer(source))
                                val reader = MultiFormatReader()
                                try {
                                    val result = reader.decode(bitmap)
                                    val text = result.toString()

                                    if (text != "") {
                                        dataProcessed = true
                                    }
                                    mainHandler.post {
                                        vm.onDniInput(text)
                                        vm.createAsistencia()
                                    }
                                } catch (e: ReaderException) {

                                }
                                image.close()
                            }
                        }
                    }

                val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
                try {
                    cameraProvider.unbindAll()
                    cameraProvider.bindToLifecycle(
                        context as ComponentActivity,
                        cameraSelector,
                        preview,
                        imageCapture,
                        imageAnalyzer
                    )
                } catch (exc: Exception) {
                    Log.e("DEBUG", "Use case binding failed", exc)
                }
            }, ContextCompat.getMainExecutor(context))
            previewView
        },
        modifier = Modifier
            //.fillMaxWidth()
            .size(width = 500.dp, height = 400.dp)
            .padding(16.dp),
    )

    if (vm.createAsistenciaResponse is Resource.Failure && !vm.isAsistenciaCreated) {
        navController.navigate(
            route = AdminAsistenciaScreen.AsistenciaNoVerificar.route
        )
        vm.isAsistenciaCreated = true
    }

}