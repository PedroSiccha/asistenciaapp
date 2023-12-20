package com.inforad.asistenciaapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun DefaultSearchView(
    value: String,
    onValueChange: (value: String) -> Unit,
    navController: NavHostController,
    onClick: () -> Unit
) {
    TopAppBar(
        title = {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = value,
                onValueChange = { text->
                    onValueChange(text)
                },
                label = {
                    Text(
                        text = "Buscar...",
                        fontSize = 15.sp
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = { onClick() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            tint = Color.Black
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle.Default.copy(fontSize = 15.sp)
            )
        },
        backgroundColor = Color.White,
    )
}