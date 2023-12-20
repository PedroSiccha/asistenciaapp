package com.inforad.asistenciaapp.domain.useCase.users

import com.inforad.asistenciaapp.domain.repository.UserRepository

class FindByUsersUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(dato: String) = repository.findByName(dato)
}