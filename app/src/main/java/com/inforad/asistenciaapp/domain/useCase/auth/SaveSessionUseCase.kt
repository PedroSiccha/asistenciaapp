package com.inforad.asistenciaapp.domain.useCase.auth

import com.inforad.asistenciaapp.domain.model.AuthResponse
import com.inforad.asistenciaapp.domain.repository.AuthRepository

class SaveSessionUseCase constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)
}