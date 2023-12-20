package com.inforad.asistenciaapp.domain.response

import com.inforad.asistenciaapp.domain.model.User

data class PromedioAsistenciaResponse(
    val prom_asistentes: String,
    val prom_noasistentes: String,
)
