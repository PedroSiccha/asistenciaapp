package com.inforad.asistenciaapp.domain.useCase.reuniones

import com.inforad.asistenciaapp.domain.model.EstadoReunion
import com.inforad.asistenciaapp.domain.repository.ReunionRepository

class CerrarReunionUseCase(private val repository: ReunionRepository) {
    suspend operator fun invoke(id: String, estado: EstadoReunion) = repository.cerrarReunion(id, estado)
}