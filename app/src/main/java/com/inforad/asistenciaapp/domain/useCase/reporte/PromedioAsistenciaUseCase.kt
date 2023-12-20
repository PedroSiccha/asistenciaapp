package com.inforad.asistenciaapp.domain.useCase.reporte

import com.inforad.asistenciaapp.domain.repository.ReporteRepository

class PromedioAsistenciaUseCase(private val repository: ReporteRepository) {
    suspend operator fun invoke() = repository.getPromAsistencia()
}