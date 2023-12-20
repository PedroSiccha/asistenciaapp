package com.inforad.asistenciaapp.domain.useCase.asistencias

import com.inforad.asistenciaapp.domain.model.Asistencia
import com.inforad.asistenciaapp.domain.repository.AsistenciaRepository

class LastAsistenciaUseCase(private val repository: AsistenciaRepository) {
    suspend operator fun invoke() = repository.getLastAsistencia()
}