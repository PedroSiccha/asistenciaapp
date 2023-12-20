package com.inforad.asistenciaapp.domain.useCase.users

import com.inforad.asistenciaapp.domain.model.User
import com.inforad.asistenciaapp.domain.repository.UserRepository
import java.io.File

class UpdateUserWithImageUseCase constructor(private val repository: UserRepository) {
    suspend operator fun invoke(id: String, user: User, file: File) = repository.updateWithImage(id, user, file)
}