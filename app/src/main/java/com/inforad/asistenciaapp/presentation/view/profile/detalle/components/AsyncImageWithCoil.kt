package com.inforad.asistenciaapp.presentation.view.profile.detalle.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.inforad.asistenciaapp.R

@Composable
fun AsyncImageWithCoil(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    contentDescription: String = "",
    contentScale: ContentScale = ContentScale.Crop
) {
    if (!imageUrl.isNullOrBlank()) {
        val painter = rememberImagePainter(imageUrl)
        Image(
            modifier = modifier,
            painter = painter,
            contentDescription = contentDescription,
            contentScale = contentScale,
            alignment = Alignment.Center
        )
    } else {
        Image(
            modifier = modifier,
            painter = painterResource(id = R.drawable.avataradmin),
            contentDescription = contentDescription,
            contentScale = contentScale,
            alignment = Alignment.Center
        )
    }
}
