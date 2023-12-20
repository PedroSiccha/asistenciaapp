package com.inforad.asistenciaapp.domain.useCase.users

import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.domain.repository.UserRepository

class DeleteUserUseCase constructor(private val repository: UserRepository) {
    suspend operator fun invoke(id: String) = repository.delete(id)
}