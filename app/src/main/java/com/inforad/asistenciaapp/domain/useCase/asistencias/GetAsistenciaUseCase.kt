package com.inforad.asistenciaapp.domain.useCase.asistencias

import com.inforad.asistenciaapp.domain.repository.AsistenciaRepository

class GetAsistenciaUseCase(private val repository: AsistenciaRepository) {
    suspend operator fun invoke(id: String) = repository.getAsistencia(id)
}
