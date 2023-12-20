package com.inforad.asistenciaapp.domain.useCase.auth

import com.inforad.asistenciaapp.domain.model.AuthResponse
import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.domain.repository.AuthRepository

class UpdateSessionUseCase constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(user: User) = repository.updateSession(user)
}