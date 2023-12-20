package com.inforad.asistenciaapp.presentation.components

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.inforad.asistenciaapp.R
import com.inforad.asistenciaapp.presentation.ui.theme.Blue500

@Composable
fun ButtonCustom(
    modifier: Modifier,
    onClick: () -> Unit,
    color: Color = Blue500,
    img: Painter = painterResource(id = R.drawable.logoprincipal)
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(backgroundColor = color)
    ) {
        Image(modifier = Modifier.size(40.dp).padding(5.dp),painter = img, contentDescription = "")
    }
}