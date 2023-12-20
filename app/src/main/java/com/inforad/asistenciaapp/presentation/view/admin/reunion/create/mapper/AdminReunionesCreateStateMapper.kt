package com.inforad.asistenciaapp.presentation.view.admin.reunion.create.mapper

import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.presentation.view.admin.reunion.create.AdminReunionesCreateState

fun AdminReunionesCreateState.toReunion(): Reunion {
    return Reunion(
        asunto = asunto,
        detalle = detalle,
        fecha = fecha,
        estado = estado
    )
}