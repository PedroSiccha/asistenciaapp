package com.inforad.asistenciaapp.domain.useCase.reporte

import com.inforad.asistenciaapp.domain.repository.ReporteRepository

class ReunionAsistenciaUseCase(private val repository: ReporteRepository) {
    suspend operator fun invoke(id: String) = repository.getReunionAsistenciaUsuario(id)
}