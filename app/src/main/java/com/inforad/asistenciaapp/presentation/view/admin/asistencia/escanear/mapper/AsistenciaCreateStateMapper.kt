package com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.mapper

import com.inforad.asistenciaapp.domain.model.Asistencia
import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.presentation.view.admin.asistencia.escanear.AsistenciaCreateState

fun AsistenciaCreateState.toAsistencia(): Asistencia {
    return Asistencia(
        estado = estado,
        hora = hora,
        dni = dni,
        reunion_id = reunion_id
    )
}