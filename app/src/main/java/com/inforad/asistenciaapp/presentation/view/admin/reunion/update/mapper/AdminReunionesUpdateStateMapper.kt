package com.inforad.asistenciaapp.presentation.view.admin.reunion.update.mapper

import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.presentation.view.admin.reunion.create.AdminReunionesCreateState
import com.inforad.asistenciaapp.presentation.view.admin.reunion.update.AdminReunionesUpdateState

fun AdminReunionesUpdateState.toReunion(): Reunion {
    return Reunion(
        asunto = asunto,
        detalle = detalle,
        fecha = fecha,
        estado = estado
    )
}