package com.inforad.asistenciaapp.domain.useCase.reuniones

import com.inforad.asistenciaapp.domain.model.Reunion
import com.inforad.asistenciaapp.domain.repository.ReunionRepository

class UpdateReunionesUseCase(private val repository: ReunionRepository) {
    suspend operator fun invoke(reunion: Reunion) = reunion.id?.let { repository.update(it, reunion) }
}