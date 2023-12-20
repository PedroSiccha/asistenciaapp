package com.inforad.asistenciaapp.domain.response

import com.inforad.asistenciaapp.domain.model.Reunion

data class AsistenciaReunionResponse(
    val id: String,
    val estado: String,
    val hora: String,
    val reunion: Reunion? = null,
)
