package com.inforad.asistenciaapp.domain.useCase.reuniones

import com.inforad.asistenciaapp.domain.repository.ReunionRepository

class GetLastReunionUseCase(private val repository: ReunionRepository) {
    suspend operator fun invoke() = repository.getLastReunion()
}