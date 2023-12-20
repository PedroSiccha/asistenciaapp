package com.inforad.asistenciaapp.domain.useCase.users

import com.inforad.asistenciaapp.domain.repository.UserRepository

class GetUsersUseCase(private val repository: UserRepository) {
    suspend operator fun invoke() = repository.getUsers()
}