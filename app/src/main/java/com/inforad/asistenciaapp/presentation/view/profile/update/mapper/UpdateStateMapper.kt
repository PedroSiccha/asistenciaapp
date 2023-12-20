package com.inforad.asistenciaapp.presentation.view.profile.update.mapper

import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.presentation.view.profile.update.ProfileUpddateState

fun ProfileUpddateState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        phone = phone,
        numeroPadron = numeroPadron,
        lote = lote,
        manzana = manzana,
        metros = metros,
        lotesCantidad = lotesCantidad,
        lotesDetalle = lotesDetalle,
        dni = dni,
        email = email
    )
}