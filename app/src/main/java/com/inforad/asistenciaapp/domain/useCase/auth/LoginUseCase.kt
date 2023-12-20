package com.inforad.asistenciaapp.domain.useCase.auth

import com.inforad.asistenciaapp.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(dni: String, password: String) = repository.login(dni, password)
}