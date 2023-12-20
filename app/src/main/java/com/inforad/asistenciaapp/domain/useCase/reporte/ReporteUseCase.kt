package com.inforad.asistenciaapp.domain.useCase.reporte

data class ReporteUseCase(
    val promedioAsistencia: PromedioAsistenciaUseCase,
    val promedioAsistenciaUsuario: PromedioAsistenciaUsuarioUseCase,
    val reunionAsistencia: ReunionAsistenciaUseCase
)
