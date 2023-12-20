package com.inforad.asistenciaapp.domain.useCase.auth

import com.inforad.asistenciaapp.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.getSessionData()
}