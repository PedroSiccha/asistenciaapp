package com.inforad.asistenciaapp.domain.useCase.reuniones

import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.repository.ReunionRepository

class CreateReunionesUseCase(private val repository: ReunionRepository) {
    suspend operator fun invoke(reunion: Reunion) = repository.create(reunion)
}