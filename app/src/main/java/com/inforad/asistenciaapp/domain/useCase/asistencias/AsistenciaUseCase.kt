package com.inforad.asistenciaapp.domain.useCase.asistencias

data class AsistenciaUseCase(
    val createUseCase: CreateAsistenciaUseCase,
    val lastAsistenciaUseCase: LastAsistenciaUseCase,
    val getAsistencia: GetAsistenciaUseCase,
)
