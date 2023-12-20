package com.inforad.asistenciaapp.presentation.view.auth.register.mapper

import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.presentation.view.auth.register.RegisterState

fun RegisterState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        dni = dni,
        email = email,
        phone = telefono,
        password = dni,
        imagen = imagen,
        numeroPadron = numeroPadron,
        lote = lote,
        manzana = manzana,
        metros = metros,
        lotesCantidad = lotesCantidad,
        lotesDetalle = lotesDetalle
    )
}