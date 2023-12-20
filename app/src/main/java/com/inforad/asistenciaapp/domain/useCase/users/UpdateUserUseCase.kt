package com.inforad.asistenciaapp.domain.useCase.users

import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.domain.repository.UserRepository

class UpdateUserUseCase constructor(private val repository: UserRepository) {
    suspend operator fun invoke(id: String, user: User) = repository.update(id, user)
}